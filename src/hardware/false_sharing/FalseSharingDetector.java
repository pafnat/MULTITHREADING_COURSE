package hardware.false_sharing;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
TODO: пример работает некорректно!

пример false sharing:
если два потока будут одновременно использовать ячейки памяти,
которые попадают в одну кэш линию, то с с точки зрения процессора,
это будет почи как совместное использование памяти, то есть получается
ложное разделение потоков.

Исходим из того, что два потока будут находится на двух независимых ядрах.
Если переменная volatile то в чистом видео 3 копии переменной в трех кэшах не будет.
Контролллер кэша (*) обнаруживает что одна и та же кэш линия находится в одном и втором ядре,
если в Core 2 прозошла запись переменной, то есть ее изменили, то в Core 1 происходит сбрасывание кэша,
и Core 1 будет вынуждено читать переменную уже из памяти.

         Core1                      Core2
         -----                     -----
        |  _  |                   |  _  |               L1 cache
         -----                     -----
                * <-------------> *
      -------------            -------------
     |    ___      |          |    ___     |            L2 cache
      -------------            -------------


  ----------------------------------------------
 |           ___                 ___            |       L3 cache
  ----------------------------------------------


 */


public class FalseSharingDetector {

    // предполагаем, что размер кэш линии 64 байта и вводим 9 переменных,
    // тогда гарантированно, одна из перменных не попадет в кэш линию
    volatile static long value0 = 0;
    volatile static long value1 = 0;
    volatile static long value2 = 0;
    volatile static long value3 = 0;
    volatile static long value4 = 0;
    volatile static long value5 = 0;
    volatile static long value6 = 0;
    volatile static long value7 = 0;
    volatile static long value8 = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        final CountDownLatch latch0 = new CountDownLatch(2);
        final CountDownLatch latch2 = new CountDownLatch(2);

        // чтобы потоки стартовали одновременно, применяем задвижку
        pool.submit(new Callable<Void>() {
            public Void call() throws Exception {
                latch0.countDown(); // Thread #1 ready
                latch0.await();     // Wait for start signal
                long t0 = System.nanoTime();
                for (int k = 0; k < 100_000_000; k++) {
                    value0 = value0 * k;
                }
                long t1 = System.nanoTime();
                System.out.println((t1 - t0) / 1000000 + "ms");
                latch2.countDown(); // Thread #1 finished
                return null;
            }
        });
        pool.submit(new Callable<Void>() {
            public Void call() throws Exception {
                latch0.countDown(); // Thread #2 ready
                latch0.await();     // Wait for start signal
                long t0 = System.nanoTime();
                for (int k = 0; k < 100_000_000; k++) {
                    value8 = value8 * k;
                }
                long t1 = System.nanoTime();
                System.out.println((t1 - t0) / 1000000 + "ms");
                latch2.countDown(); // Thread #2 finished
                return null;
            }
        });
        latch2.await();     // Wait for #1 + #2 threads finished

        pool.shutdownNow(); // kill thread pool
    }
}

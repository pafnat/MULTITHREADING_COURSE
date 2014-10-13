package hardware.cache_line;

/*
    размер кэш-линии

    для проверки на mac: http://stackoverflow.com/questions/5446134/determine-values-of-several-system-variables-in-the-terminal-in-a-mac


 */
public class CacheLineDetector {
    
    final static int ARRAY_SIZE = 2 * 1024 * 1024;

    public static void main(String[] args) {

        // массив long 16МБ
        long[] array = new long[ARRAY_SIZE];

        // выполняем эксперимент 10 раз
        for (int testIndex = 0; testIndex < 10; testIndex++) {
            testMethod(array);
            System.out.println("--");
        }

    }

    private static void testMethod(long[] array) {
        // логарифмический цикл
        // предполгаемое количество long которое умещается в кэш линии
        // step - шаг индекса при доступе к элементу массива
        for (int stepSize = 1; stepSize <= 64; stepSize *=2) {
            long sum = 0;

            long t0 = System.nanoTime();
            // эксперимнт
            for (int n = 0; n < 10; n++) {
                for (int k = 0; k < array.length; k += stepSize) {
                    sum += array[k];
                }

            }
            long t1 = System.nanoTime();

            // для предотвращения возможной оптимизации jvm
            if (sum > 0) {
                throw new Error();
            }

            int step_count = ARRAY_SIZE / stepSize;

            System.out.println("stepSize: "+ 8 * stepSize + ". dT / step_count: " + (t1 - t0) / step_count);


        }
    }
}

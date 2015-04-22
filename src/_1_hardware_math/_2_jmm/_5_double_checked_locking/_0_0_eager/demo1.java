package _1_hardware_math._2_jmm._5_double_checked_locking._0_0_eager;

import net.golovach.multicore_course._1_hardware_math._2_jmm._5_double_checked_locking._0_0__early.Singleton;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class demo1 {
    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue<Singleton> queue = new LinkedBlockingQueue<>();
        new Thread(new Runnable() {
            public void run() {
                queue.add(Singleton.instance);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                queue.add(Singleton.instance);
            }
        }).start();

        System.out.println(queue.take() == queue.take());
    }
}

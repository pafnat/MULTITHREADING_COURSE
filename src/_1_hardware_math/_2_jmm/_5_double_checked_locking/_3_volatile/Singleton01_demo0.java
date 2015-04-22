package _1_hardware_math._2_jmm._5_double_checked_locking._3_volatile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// может быть
// [0]
// [1]
public class Singleton01_demo0 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                Singleton01 instance = Singleton01.getInstance();
                instance.getState().add(0);
                System.out.println(instance.getState());
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                Singleton01 instance = Singleton01.getInstance();
                instance.getState().add(1);
                System.out.println(instance.getState());
            }
        }).start();
    }
}

package _1_hardware_math._2_jmm._5_double_checked_locking._5_thread_local;

import net.golovach.multicore_course._1_hardware_math._2_jmm._5_double_checked_locking._3_volatile.Singleton01;

// гарантированно будет
// [0]
// [1]
public class Singleton00_demo0 {
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

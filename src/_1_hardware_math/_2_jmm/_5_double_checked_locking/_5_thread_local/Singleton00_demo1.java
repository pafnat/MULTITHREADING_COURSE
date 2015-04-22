package _1_hardware_math._2_jmm._5_double_checked_locking._5_thread_local;

import net.golovach.multicore_course._1_hardware_math._2_jmm._5_double_checked_locking._3_volatile.Singleton01;

// гарантированно будет
// [0, 1, 2]
// [3, 4, 5]
public class Singleton00_demo1 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                Singleton01.getInstance().getState().add(0);
                Singleton01.getInstance().getState().add(1);
                Singleton01.getInstance().getState().add(2);
                System.out.println(Singleton01.getInstance().getState());
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                Singleton01.getInstance().getState().add(3);
                Singleton01.getInstance().getState().add(4);
                Singleton01.getInstance().getState().add(5);
                System.out.println(Singleton01.getInstance().getState());
            }
        }).start();
    }
}

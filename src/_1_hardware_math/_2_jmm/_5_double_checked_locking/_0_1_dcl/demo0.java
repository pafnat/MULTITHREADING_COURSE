package _1_hardware_math._2_jmm._5_double_checked_locking._0_1_dcl;

public class demo0 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Singleton02.getInstance().getState()); // 1
            }
        }).start();

        System.out.println(Singleton02.getInstance().getState()); // 0
    }
}

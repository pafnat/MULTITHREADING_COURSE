package _1_hardware_math._2_jmm._5_double_checked_locking._5_thread_local;

public class _02_demo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                Singleton02.getInstance().getState().add("A");
                Singleton02.getInstance().getState().add("B");
                Singleton02.getInstance().getState().add("C");
                System.out.println(Singleton02.getInstance().getState());
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                Singleton02.getInstance().getState().add("X");
                Singleton02.getInstance().getState().add("Y");
                Singleton02.getInstance().getState().add("Z");
                System.out.println(Singleton02.getInstance().getState());
            }
        }).start();
    }
}

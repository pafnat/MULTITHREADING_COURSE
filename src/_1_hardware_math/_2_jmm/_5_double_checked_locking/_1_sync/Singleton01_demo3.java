package _1_hardware_math._2_jmm._5_double_checked_locking._1_sync;

// todo: убедитесь в этом!!!
public class Singleton01_demo3 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (Singleton01.getInstance().state == 1); // 0..Inf
            }
        }).start();

//        Singleton01.getInstance().setState(0);
        Singleton01 ref = Singleton01.getInstance();
        ref.setState(0);
    }
}

package _1_hardware_math._2_jmm._5_double_checked_locking._1_sync;

// todo: убедитесь в этом!!!
// monitor_exit --(happend-before) --> monitor_enter
public class Singleton01_demo1 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (Singleton01.getInstance().state == 1); // 0..Inf
            }
        }).start();

        Singleton01.getInstance().state = 0;
//        Singleton01.getInstance().state = 0; // остановится!
//        Singleton01 ref = Singleton01.getInstance();
//        ref.state = 0;
    }
}

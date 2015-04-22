package _1_hardware_math._2_jmm._5_double_checked_locking._1_sync;

// monitor_exit --(happend-before) --> monitor_enter
public class Singleton01_demo2 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    // monitor_enter + monitor_exit
                    Singleton01 instance = Singleton01.getInstance();
                    // nothing
                    int tmp = instance.state;
                    if (tmp != 0) {
                        break;
                    }
                }
            }
        }).start();

        // monitor_enter + monitor_exit
        Singleton01 instance = Singleton01.getInstance();
        // nothing
        instance.state = 1;
    }
}

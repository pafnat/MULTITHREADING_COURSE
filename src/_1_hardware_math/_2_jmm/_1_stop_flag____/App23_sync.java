package _1_hardware_math._2_jmm._1_stop_flag____;

public class App23_sync {
    static boolean run = true;
    static Object lock = new Object();

    static void setRun(boolean newRun) {
        run = newRun;
    }

    static boolean getRun() {
        synchronized (lock) {
            return run;
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (getRun()) ; // 0 .. inf
            }
        }).start();

        setRun(false);
    }
}

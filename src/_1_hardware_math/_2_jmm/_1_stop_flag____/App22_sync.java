package _1_hardware_math._2_jmm._1_stop_flag____;

/* остановка не гарантируется (чтение без syncronized) и не обеспечивается взаимная блокировка, synchronized */
public class App22_sync {
    static boolean run = true;
    static Object lock = new Object();

    static void setRun(boolean newRun) {
        synchronized (lock) {
            run = newRun;
        }
    }

    static boolean getRun() {
        return run;
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

package _1_hardware_math._2_jmm._1_stop_flag____;

/* не создается happens-before
Это означает что нельзя синхронизироваться по разных объектам
*/
public class App21_sync {
    static boolean run = true;
    static Object lockA = new Object();
    static Object lockB = new Object();

    static void setRun(boolean newRun) {
        synchronized (lockA) {
            run = newRun;
        }
    }

    static boolean getRun() {
        synchronized (lockB) {
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

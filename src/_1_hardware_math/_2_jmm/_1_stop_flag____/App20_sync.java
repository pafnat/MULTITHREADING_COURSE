package _1_hardware_math._2_jmm._1_stop_flag____;

/* синхронизация возможно по Object, и даже по String, но не по примитивам */
/* эта программа гарантированно остановится, как и в примере с volatile, но непонятно за какое время */
/* этот пример есть в книге Блоха "Эффективная Java" */

public class App20_sync {
    static boolean run = true;
    static Object lock = new Object();

    static void setRun(boolean newRun) {
        synchronized (lock) {
            run = newRun;
        }
    }

    static boolean getRun() {
        synchronized (lock) {
            return run;
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (getRun()); // 0 .. N
            }
        }).start();

        setRun(false);
    }
}

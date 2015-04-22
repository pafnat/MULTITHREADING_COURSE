package _1_hardware_math._2_jmm._1_stop_flag____;

public class d {
    static boolean run = true;

    public static synchronized boolean isRun() {
        return run;
    }

    public static /*synchronized */void setRun(boolean run) {
        d.run = run;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new Runnable() {
            public void run() {
                setRun(false);
            }
        });
        newThread.start();

        while (isRun());
    }
}

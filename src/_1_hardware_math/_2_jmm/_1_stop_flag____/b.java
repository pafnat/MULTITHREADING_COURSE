package _1_hardware_math._2_jmm._1_stop_flag____;

public class b {
    static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new Runnable() {
            public void run() {
                run = false;
            }
        });
        newThread.start();

        newThread.join();

        System.out.println(run); // f
    }
}

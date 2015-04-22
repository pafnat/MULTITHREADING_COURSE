package _1_hardware_math._2_jmm._1_stop_flag____;

public class a {
    static boolean run = true;

    public static void main(String[] args) {
        Thread newThread = new Thread(new Runnable() {
            public void run() {
                run = false;
            }
        });
        newThread.start();

        while (newThread.isAlive()); // t t t f
        System.out.println(run); // f
    }
}

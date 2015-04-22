package _1_hardware_math._2_jmm._1_stop_flag____;

public class e {
    static boolean run = true;
    static Object refA = new Object();
    static Object refB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new Runnable() {
            public void run() {
                synchronized (refA) {
                    run = false;
                }
            }
        });
        newThread.start();

        while (true) {
            synchronized (refB) {
                System.out.println(run);
            }
        }
    }
}

/*


true
false
false
false
false
....
inf
 */
package _1_hardware_math._2_jmm._1_stop_flag____;

public class c {
    static boolean run = true;
    static Object ref = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new Runnable() {
            public void run() {
                synchronized (ref) {
                    run = false;
                }
            }
        });
        newThread.start();

        while (true) {
            synchronized (ref) {
                System.out.println(run);
            }
        }
    }
}

/*


true
true
true
true
true
true
true
true
false
false
false
false
false
false
false
false
...
inf

 */
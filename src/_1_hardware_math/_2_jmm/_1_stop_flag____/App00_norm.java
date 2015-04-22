package _1_hardware_math._2_jmm._1_stop_flag____;

/*

напечатает 1

 */
public class App00_norm {
    static int data = 0;
    static volatile boolean run = true;

    public static void main(String[] args) {
        Thread newThread = new Thread(new Runnable() {
            public void run() {
                while (run) ; // 0 .. inf
                System.out.println(data); // 1!!!
//                while (true) ; // 0 .. inf
            }
        });
        newThread.start();
        data = 1;
        run = false;
//        run = false;
    }
}

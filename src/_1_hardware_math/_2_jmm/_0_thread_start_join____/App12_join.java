package _1_hardware_math._2_jmm._0_thread_start_join____;

// может работать неограниченно долго и напечатать 0 или 1
public class App12_join {
    static int x = 0;
    static int y = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new Runnable() {
            public void run() {
                x = 1;
                y = 1;
            }
        });
        newThread.start();

//        newThread.join(); // БЕЗ join
        while (y == 0); // 0 .. inf
        System.out.println(" state=" + x); // 0, 1
    }
}

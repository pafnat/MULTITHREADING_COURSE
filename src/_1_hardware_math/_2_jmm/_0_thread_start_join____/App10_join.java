package _1_hardware_math._2_jmm._0_thread_start_join____;

// точно напечатает 1
public class App10_join {
    static int x = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new Runnable() {
            public void run() {
                x = 1;
            }
        });
        newThread.start();

        newThread.join();
        System.out.println(x); // 1
    }
}

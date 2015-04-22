package _1_hardware_math._2_jmm._0_thread_start_join____;

// может напечатать только 1
public class App00_start {
    static int x = 0;
    public static void main(String[] args) {
        x = 1;
        new Thread(new Runnable() {
            public void run() {
                System.out.println(x); // 1
            }
        }).start();
    }
}

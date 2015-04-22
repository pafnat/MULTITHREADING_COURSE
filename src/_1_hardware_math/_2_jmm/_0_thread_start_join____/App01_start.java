package _1_hardware_math._2_jmm._0_thread_start_join____;

// гарантированно остановится
public class App01_start {
    static int x = 0;
    public static void main(String[] args) {
        x = 1;
        new Thread(new Runnable() {
            public void run() {
                while (x == 0); // 0 .. N
            }
        }).start();
    }
}

package _1_hardware_math._2_jmm._0_thread_start_join____;

// но тут может работать неограниченно долго
public class App02_start {
    static int x = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (x == 0); // 0 .. inf
            }
        }).start();
        x = 1;
    }
}

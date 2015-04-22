package _1_hardware_math._2_jmm._0_thread_start_join____;

// гарантированно напечатает 1 1
public class App03_start {
    static int x = 0;
    static int y = 0;
    public static void main(String[] args) {
        x = 1;
        y = 1;
        new Thread(new Runnable() {
            public void run() {
                System.out.println(y); // 1
                System.out.println(x); // 1
            }
        }).start();
    }
}

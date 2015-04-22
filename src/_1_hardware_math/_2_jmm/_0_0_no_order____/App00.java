package _1_hardware_math._2_jmm._0_0_no_order____;

public class App00 {
    static int x = 0;
    static int y = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                // y=0 x=0
                // y=0 x=1
                // y=1 x=1
                // y=1 x=0 !!!
                System.out.print(" y=" + y);
                System.out.print(" x=" + x);
            }
        }).start();

        x = 1;
        y = 1;
    }
}

package _1_hardware_math._2_jmm._5_double_checked_locking._0_1_dcl;

public class Singleton00 {
    private Singleton00() {}

    private static Singleton00 instance;
    public static Singleton00 getInstance() {
        if (instance == null) {
            synchronized (Singleton00.class) {
                if (instance == null) {
                    instance = new Singleton00();
                }
            }
        }
        return instance; // может вернуть null
    }
}

class T {
    static int x = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                x = 1;
            }
        }).start();

        System.out.println(x); // 1
        System.out.println(x); // 0
    }
}

package _1_hardware_math._2_jmm._1_stop_flag____;

public class App {
    volatile static Str str = null; // UNsafe publishing

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                str = new Str(new char[]{'H', 'e', 'l', 'l', '0'}, 1, 5);
            }
        }).start();

        while (true) { // 0 .. inf
            Str tmp = str;
            if (tmp != null) {
                System.out.println(tmp.value); // Hello
                System.out.println(tmp.off); // 1
                System.out.println(tmp.len); // 5
                break;
            }
        }
        // "Hello", 1, 5
    }
}

class Str {
    final char[] value;
    final int off;
    final int len;

    Str(char[] value, int off, int len) {
        this.value = value;
        this.off = off;
        this.len = len;
    }
}


class DDD {
    static Object ref = new Object();
    static int x = 0;
    static int y = 0;

    public static void main(String[] args) throws InterruptedException {


        new Thread(new Runnable() {
            public void run() {
                synchronized (ref) {
                    try {
                        ref.wait();
                        System.out.println(x + ":" + y);
                    } catch (InterruptedException e) {}
                }
            }
        }).start();

        synchronized (ref) {
            x = 1;
            ref.notify();
            y = 1;
            while (true);
        }
    }
}
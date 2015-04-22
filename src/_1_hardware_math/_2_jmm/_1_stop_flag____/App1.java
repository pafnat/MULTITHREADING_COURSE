package _1_hardware_math._2_jmm._1_stop_flag____;

public class App1 {
    static Str str = null;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                str = new Str(new char[] {'H', 'e', 'l', 'l', '0'}, 1, 5);
            }
        }).start();

        while (str == null) {
            System.out.println(str.value);
            System.out.println(str.off);
            System.out.println(str.len);
        }
        // NPE
        // null, 0, 0
        // "Hello", 0, 0
        // "Hello", 0, 5
        // null, 1, 5
    }
}


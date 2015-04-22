package _1_hardware_math._2_jmm._3_final____;

public class App04 {
    static FinalIntHolder2 holder;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (true) {  // 0 .. inf
                    FinalIntHolder2 tmp = holder;
                    if (tmp != null) {
                        System.out.println(tmp.finalValue); // 1
                        System.out.println(tmp.value); // 0, 1
                    }
                }
            }
        }).start();

        holder = new FinalIntHolder2(1, 1);
    }
}

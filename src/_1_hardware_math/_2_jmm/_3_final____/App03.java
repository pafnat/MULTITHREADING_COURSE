package _1_hardware_math._2_jmm._3_final____;

public class App03 {
    static int data = 0;
    static FinalIntHolder holder;            
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (true) {  // 0 .. inf
                    FinalIntHolder tmp = holder;
                    if (tmp != null) {
                        System.out.println(tmp.value); // 1
                        System.out.println(data); // 0, 1
                    }
                }
            }
        }).start();

        data = 1;
        holder = new FinalIntHolder(1);
    }
}

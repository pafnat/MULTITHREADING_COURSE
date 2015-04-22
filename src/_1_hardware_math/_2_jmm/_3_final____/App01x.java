package _1_hardware_math._2_jmm._3_final____;

public class App01x {
    private static FinalIntHolder holder;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (true) { // 0 .. inf
                    FinalIntHolder tmp = holder;
                    if (tmp != null) {
                        System.out.println(tmp.value); // 1
                        break;
                    }
                }
            }
        }).start();

        holder = new FinalIntHolder(1);
    }
}

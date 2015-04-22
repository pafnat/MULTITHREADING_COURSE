package _1_hardware_math._2_jmm._3_final____;

public class App00x {
    private static IntHolder holder;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (true) {  // 0 .. inf
                    IntHolder tmp = holder;
                    if (tmp != null) {
                        System.out.println(tmp.value); // 0, 1
                        break;
                    }
                }
            }
        }).start();

        holder = new IntHolder(1);
    }
}

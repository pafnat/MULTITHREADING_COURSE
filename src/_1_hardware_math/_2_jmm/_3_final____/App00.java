package _1_hardware_math._2_jmm._3_final____;

/*
может висеть неограниченно долго
но также может напечатать 0 или 1
 */
public class App00 {
    private static IntHolder holder;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                while (holder == null); // 0 .. inf
                System.out.println(holder.value); // 0, 1, ???NullPointerException
            }
        }).start();

        holder = new IntHolder(1);

    }
}

package _1_hardware_math._2_jmm._3_final____;

/*
использование класса FinalIntHolder мы гарантированно увидем значение финальных полей = 1

 */
public class App01 {
    private static FinalIntHolder holder;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (holder == null); // 0 .. inf
                System.out.println(holder.value); // 1, ???NullPointerException
            }
        }).start();

        holder = new FinalIntHolder(1);
    }
}

package _1_hardware_math._2_jmm._0_1_causality_loop____;

// хотя в случае ОТСУТСТВИЯ запрета на out-of-thin-air в JMM
// процессор мог бы сделать спекулятивную запись и модифицировать код
// до такого состояния
public class App00x {
    static int x = 0;
    static int y = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                y = 1;
                if (x == 0) {
                    y = 0;
                }
            }
        }).start();

        x = 1;
        if (y == 0) {
            x = 0;
        }
    }
}

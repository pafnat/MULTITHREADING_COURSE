package _1_hardware_math._2_jmm._1_stop_flag____;


/*

пример негарантированной остановки программы:
Согласно спецификации JMM и в зависимости от реализации JVM, run может стать true, а может и не стать.

 */

public class App10_01 {

    static boolean run = true;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                while (run);
            }
        }).start();

        run = false;

    }

}

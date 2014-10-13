package hardware_math.stop_flag;


/*

пример негарантированной остановки программы:
Согласно спецификации JMM и в зависимости от реализации JVM, run может стать true, а может и не стать.

 */

public class App00 {

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

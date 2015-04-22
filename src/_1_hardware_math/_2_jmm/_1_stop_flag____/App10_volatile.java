package _1_hardware_math._2_jmm._1_stop_flag____;

/* программа гарантированно остановится, но непонятно за сколько */

/* в спеке либо линериализованная модель памяти либо sequal consinstency. Сделали sequal consistency. */

/* в спецификации не сказано с какой скоростью происзодит запись в volatile перменную */

public class App10_volatile {

    static volatile boolean run = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while(run); // 0 .. N
            }
        }).start();

        run = false;
    }

}

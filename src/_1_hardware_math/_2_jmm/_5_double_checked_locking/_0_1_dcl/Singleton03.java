package _1_hardware_math._2_jmm._5_double_checked_locking._0_1_dcl;

public class Singleton03 {
    private final int state; // добавили final
    private Singleton03(int state) {this.state = state;}
    public int getState() {return state;} // НЕ может вернуть 0

    private static Singleton03 instance;
    public static Singleton03 getInstance() {
        Singleton03 tmp = instance;
        if (tmp == null) {
            synchronized (Singleton03.class) {
                if (instance == null) {
                    tmp = new Singleton03(1);
                    instance = tmp;
                }
            }
        }
        return tmp; // НЕ может вернуть null
    }
}

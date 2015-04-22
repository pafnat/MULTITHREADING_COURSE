package _1_hardware_math._2_jmm._5_double_checked_locking._0_1_dcl;

public class Singleton02 {
    private int state;
    private Singleton02(int state) {this.state = state;}
    public int getState() {return state;} // может вернуть 0

    private static Singleton02 instance;
    public static Singleton02 getInstance() {
        Singleton02 tmp = instance;
        if (tmp == null) {
            synchronized (Singleton02.class) {
                if (instance == null) {
                    tmp = new Singleton02(1);
                    instance = tmp;
                }
            }
        }
        return tmp; // НЕ может вернуть null
    }
}

package _1_hardware_math._2_jmm._5_double_checked_locking._0_1_dcl;

public class Singleton04 {
    private int state;
    private Singleton04(int state) {this.state = state;}
    public int getState() {return state;} // НЕ может вернуть 0

    private volatile static Singleton04 instance; // добавили volatile
    public static Singleton04 getInstance() {
        Singleton04 tmp = instance;
        if (tmp == null) {
            synchronized (Singleton04.class) {
                if (instance == null) {
                    tmp = new Singleton04(1);
                    instance = tmp;
                }
            }
        }
        return tmp; // НЕ может вернуть null
    }
}

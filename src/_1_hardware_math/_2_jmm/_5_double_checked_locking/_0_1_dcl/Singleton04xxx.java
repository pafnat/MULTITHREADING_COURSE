package _1_hardware_math._2_jmm._5_double_checked_locking._0_1_dcl;

//todo: ???
public class Singleton04xxx {
    private volatile int state; // добавили volatile
    private Singleton04xxx(int state) {this.state = state;}
    public int getState() {return state;} // НЕ может вернуть 0

    private static Singleton04xxx instance;
    public static Singleton04xxx getInstance() {
        Singleton04xxx tmp = instance;
        if (tmp == null) {
            synchronized (Singleton04xxx.class) {
                if (instance == null) {
                    tmp = new Singleton04xxx(1);
                    instance = tmp;
                }
            }
        }
        return tmp; // НЕ может вернуть null
    }
}

package _1_hardware_math._2_jmm._5_double_checked_locking._0_1_dcl;

public class Singleton01 {
    private Singleton01() {}

    private static Singleton01 instance;
    public static Singleton01 getInstance() {
        Singleton01 tmp = instance;
        if (tmp == null) {
            synchronized (Singleton01.class) {
                if (instance == null) {
                    tmp = new Singleton01();
                    instance = tmp;
                }
            }
        }
        return tmp; // НЕ может вернуть null
    }
}

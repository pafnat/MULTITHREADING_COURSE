package _1_hardware_math._2_jmm._5_double_checked_locking._0_0__demo;

public class DCLSingleton {
    private DCLSingleton() {}

    private static DCLSingleton instance;
    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}

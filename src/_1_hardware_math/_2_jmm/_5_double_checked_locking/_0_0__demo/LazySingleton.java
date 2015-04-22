package _1_hardware_math._2_jmm._5_double_checked_locking._0_0__demo;

// Singleton01.getInstance()
// Singleton01.getInstance()
// Singleton01 ref = Singleton01.getInstance()
// ref
// ref
public class LazySingleton {
    private LazySingleton() {}

    private static LazySingleton instance;
    public synchronized static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

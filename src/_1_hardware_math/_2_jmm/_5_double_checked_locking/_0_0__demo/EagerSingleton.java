package _1_hardware_math._2_jmm._5_double_checked_locking._0_0__demo;

// Singleton01.instance
public class EagerSingleton {
    private EagerSingleton() {}
    public static final EagerSingleton instance = new EagerSingleton();
}


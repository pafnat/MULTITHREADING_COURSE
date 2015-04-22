package _1_hardware_math._2_jmm._5_double_checked_locking._0_0__many;

public class MSingleton {
    public static final MSingleton instance = new MSingleton();
    private MSingleton() {
        System.out.println("Singleton initialized!");
    }
}

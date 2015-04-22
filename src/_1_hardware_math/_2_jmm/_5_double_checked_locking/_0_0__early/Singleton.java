package _1_hardware_math._2_jmm._5_double_checked_locking._0_0__early;

public class Singleton {
    public static final Singleton instance = new Singleton();
    public static final int finalStaticField = 42;
    public static int staticField = 42;
    public static void staticMethod() {}

    private Singleton() {
        System.out.println("Singleton initialized!");
    }
}

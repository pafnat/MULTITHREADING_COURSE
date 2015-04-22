package _1_hardware_math._2_jmm._5_double_checked_locking._0_0__early;

public class Demo01 {
    public static Singleton staticField;
    public Singleton instanceField;

    public static void main(String[] args) {
        Singleton singletonRef = null;
        Demo01 demoRef = new Demo01();
        demoRef.method();
        System.out.println("main");
    }

    public void method() {}
}

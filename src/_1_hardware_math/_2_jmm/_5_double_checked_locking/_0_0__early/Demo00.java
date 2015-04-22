package _1_hardware_math._2_jmm._5_double_checked_locking._0_0__early;

public class Demo00 {
    public static Singleton staticField;
    public Singleton instanceField;

    public static void main(String[] args) {
        Singleton localRef = null;
        System.out.println("main");

        new Demo00().method1(null);
        new Demo00().method2();

        System.out.println(Singleton.finalStaticField);
    }

    public void method0(Singleton ref0) {
        Singleton ref1 = Singleton.instance;
    }

    public void method1(Singleton ref0) {
    }

    public void method2() {
        if (true) throw new Error();
        Singleton ref1 = Singleton.instance;
    }

    public static void staticMethod(Singleton ref0) {
        Singleton ref1 = Singleton.instance;
    }
}

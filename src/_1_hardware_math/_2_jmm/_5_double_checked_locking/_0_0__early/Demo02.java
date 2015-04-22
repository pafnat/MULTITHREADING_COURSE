package _1_hardware_math._2_jmm._5_double_checked_locking._0_0__early;

public class Demo02 {
    public static Singleton staticField;
    public Singleton instanceField;

    public static void main(String[] args) {
        staticField = null;
        new Demo02().instanceField = null;
        System.out.println(staticField);
        System.out.println(new Demo02().instanceField);

        new Demo02().instanceMethod(null);
        staticMethod(null);

        System.out.println("main");
    }

    public void instanceMethod(Singleton ref) {
    }

    public static void staticMethod(Singleton ref) {
    }
}

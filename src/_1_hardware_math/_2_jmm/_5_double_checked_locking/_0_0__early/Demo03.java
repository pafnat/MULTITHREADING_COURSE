package _1_hardware_math._2_jmm._5_double_checked_locking._0_0__early;

public class Demo03 {
    public static void main(String[] args) {
        System.out.println(Singleton.finalStaticField);
        exceptionalMethod();
    }

    public static void exceptionalMethod() {
        if (true) {
            throw new Error();
        }
        Singleton ref = Singleton.instance;
    }
}

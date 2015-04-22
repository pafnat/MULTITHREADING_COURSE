package _1_hardware_math._2_jmm._5_double_checked_locking._0_0_eager;

import net.golovach.multicore_course._1_hardware_math._2_jmm._5_double_checked_locking._0_0__early.Singleton;

public class Singleton00_demo2 {
    public static void main(String[] args) {
        new Singleton00_demo2();
        System.out.println("main");
    }
    public void test() {
        Singleton instance = Singleton.instance;
    }
}

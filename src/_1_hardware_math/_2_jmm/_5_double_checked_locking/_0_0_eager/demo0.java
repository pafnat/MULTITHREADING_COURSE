package _1_hardware_math._2_jmm._5_double_checked_locking._0_0_eager;

import net.golovach.multicore_course._1_hardware_math._2_jmm._5_double_checked_locking._0_0__early.Singleton;

public class demo0 {
    public static void main(String[] args) throws ClassNotFoundException {
        Singleton ref0 = Singleton.instance;
        Singleton ref1 = Singleton.instance;
        System.out.println(ref0 == ref1);
    }
}

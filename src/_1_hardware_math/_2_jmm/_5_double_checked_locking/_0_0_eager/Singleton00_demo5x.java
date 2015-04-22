package _1_hardware_math._2_jmm._5_double_checked_locking._0_0_eager;

import net.golovach.multicore_course._1_hardware_math._2_jmm._5_double_checked_locking._0_0__early.Singleton;

import java.io.IOException;

public class Singleton00_demo5x {
    public static void main(String[] args) throws IOException {
        Singleton.staticMethod();
        System.out.println("main");
    }
}

package _1_hardware_math._2_jmm._5_double_checked_locking._0_0_eager;

import net.golovach.multicore_course._1_hardware_math._2_jmm._5_double_checked_locking._0_0__early.Singleton;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class demo12 {
    public static final String CLASS_NAME = "net.golovach.multicore_course._1_hardware_math._2_jmm._5_double_checked_locking._0_0_early.Singleton00";

    // locate, load, and link, ???initialize
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ClassLoader loader0 = new ClassLoader() {};
        Class clazz0 = Class.forName(CLASS_NAME, false, loader0);
        Field field0 = clazz0.getDeclaredField("instance");
        Object instance0 = (Singleton)field0.get(null);

        ClassLoader loader1 = new ClassLoader() {};
        Class clazz1 = Class.forName(CLASS_NAME, false, loader1);
        Field field1 = clazz1.getDeclaredField("instance");
        Object instance1 = (Singleton)field1.get(null);
    }
}

package _1_hardware_math._2_jmm._5_double_checked_locking._0_0_eager;

import java.lang.reflect.InvocationTargetException;

public class demo11 {
    public static final String CLASS_NAME = "net.golovach.multicore_course._1_hardware_math._2_jmm._5_double_checked_locking._0_0_early.Singleton00";

    // locate, load, and link, ???initialize
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ClassLoader loader = new ClassLoader() {
        };
        Class clazz = Class.forName(CLASS_NAME, false, loader);
//        Field f = clazz.getDeclaredField("SOMETHING");
//        System.out.println(f.get(null));
//        Method m = clazz.getDeclaredMethod("test");
//        System.out.println(m.invoke(null));
    }
}

package _1_hardware_math._2_jmm._5_double_checked_locking._0_0__many;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App00 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        final String className = "net.golovach.multicore_course._1_hardware_math._2_jmm._5_double_checked_locking._0_0__many.MSingleton";

        final byte[] rawClass = Files.readAllBytes(Paths.get("D:/IDEA_PROJECTS/_2_BUSSINESS/MULTITHREADING_COURSE/out/production/MULTITHREADING_COURSE/net/golovach/multicore_course/_1_hardware_math/_2_jmm/_5_double_checked_locking/_0_0__many/MSingleton.class"));

        Class.forName(className, true, new ClassLoader() {
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                System.err.println("0");
                return super.loadClass(name);
            }

            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
                System.err.println("1");
                return defineClass(className, rawClass, 0, rawClass.length);
            }
        });
        Class.forName(className, true, new ClassLoader() {
        });
    }
}

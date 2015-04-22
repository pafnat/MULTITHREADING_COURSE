package _1_hardware_math._2_jmm._5_double_checked_locking._5_thread_local;

import java.util.ArrayList;
import java.util.List;

public class Singleton02 {
    private List<String> state;
    private Singleton02(List<String> state) {this.state = state;}
    public List<String> getState() {return this.state;}

    private static ThreadLocal<Singleton02> instance = new ThreadLocal<>();
    public static Singleton02 getInstance() {
        if (instance.get() == null) {
            instance.set(new Singleton02(new ArrayList<String>()));
        }
        return instance.get();
    }
}

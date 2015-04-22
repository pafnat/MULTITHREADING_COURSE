package _1_hardware_math._2_jmm._5_double_checked_locking._3_volatile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Singleton01 {
    private List<Integer> state;
    public Singleton01(List<Integer> state) {this.state = state;}
    public List<Integer> getState() {return this.state;}

    private static volatile Singleton01 instance;
    public static Singleton01 getInstance() {
        if (instance == null) {
            instance = new Singleton01(Collections.synchronizedList(new ArrayList<Integer>()));
        }
        return instance;
    }
}

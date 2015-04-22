package _1_hardware_math._2_jmm._5_double_checked_locking._3_volatile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Singleton01xxx {
    private List<Integer> state;
    public Singleton01xxx(List<Integer> state) {this.state = state;}
    public List<Integer> getState() {return this.state;}

    private static volatile Singleton01xxx instance;
    public static Singleton01xxx getInstance() {
        Singleton01xxx tmp = instance;
        if (tmp == null) {
            tmp = new Singleton01xxx(Collections.synchronizedList(new ArrayList<Integer>()));
            instance = tmp;
        }
        return tmp;
    }
}

package _1_hardware_math._2_jmm._5_double_checked_locking._7_atomic_lazySet;

import java.util.concurrent.atomic.AtomicReference;

// http://cheremin.blogspot.com/2011/10/atomicxxxlazyset.html
// http://cheremin.blogspot.com/2012/04/lazyset-jmm.html
public class Singleton00 {
    private int state;
    private Singleton00(int state) {this.state = state;}
    public int getState() {return this.state;}

    private static AtomicReference<Singleton00> instance = new AtomicReference<>();
    public static Singleton00 getInstance() {
        if (instance.get() == null) {
            instance.lazySet(new Singleton00(1));
        }
        return instance.get();
    }
}

package _1_hardware_math._2_jmm._5_double_checked_locking._6_atomic_cas;

import java.util.concurrent.atomic.AtomicReference;

public class Singleton00 {
    private int state;
    private Singleton00(int state) {this.state = state;}
    public int getState() {return this.state;}

    private static AtomicReference<Singleton00> instance = new AtomicReference<>();
    public static Singleton00 getInstance() {
        if (instance.get() == null) {
            instance.compareAndSet(null, new Singleton00(1)); // CAS
        }
        return instance.get();
    }
}

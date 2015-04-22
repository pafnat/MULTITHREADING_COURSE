package _1_hardware_math._2_jmm._5_double_checked_locking._6_atomic_cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Singleton02 {
    private AtomicInteger state;
    private Singleton02(int startValue) {this.state = new AtomicInteger(startValue);}
    public int getState() {return this.state.get();}
    public int incAndGetState() {return this.state.incrementAndGet();}

    private static AtomicReference<Singleton02> instance = new AtomicReference<>();
    public static Singleton02 getInstance() {
        if (instance.get() == null) {
            instance.set(new Singleton02(0));
        }
        return instance.get();
    }
}

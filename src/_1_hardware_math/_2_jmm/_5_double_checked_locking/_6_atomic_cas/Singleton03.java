package _1_hardware_math._2_jmm._5_double_checked_locking._6_atomic_cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

// http://mechanical-sympathy.blogspot.co.uk/2011/09/adventures-with-atomiclong.html
// http://mechanical-sympathy.blogspot.com/2013/01/further-adventures-with-cas.html

/**
 * 1.(OR) lock the front-side/memory bus (FSB) for serialising memory access
 * 2.(OR) exclusive lock on the cache-line for modification.
 */
public class Singleton03 {
    private AtomicInteger state;
    private Singleton03(int startValue) {this.state = new AtomicInteger(startValue);}
    public int getState() {return this.state.get();}
    public int incAndGetState() {
        while (true) {
            int current = state.get();
            int next = current + 1;
            if (state.compareAndSet(current, next)) {
                return next;
            }
        }
    }

    private static AtomicReference<Singleton03> instance = new AtomicReference<>();
    public static Singleton03 getInstance() {
        if (instance.get() == null) {
            instance.set(new Singleton03(0));
        }
        return instance.get();
    }
}

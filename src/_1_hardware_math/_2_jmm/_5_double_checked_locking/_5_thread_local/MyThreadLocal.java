package _1_hardware_math._2_jmm._5_double_checked_locking._5_thread_local;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

// MyThreadLocal -> !!!values!!! -> currentThread() - > T
// MyThreadLocal -> currentThread() - > T
public class MyThreadLocal<T> {
    private final Map<Thread, T> values
            = new ConcurrentHashMap<>();
//    private final Map<Thread, T> values
//            = Collections.synchronizedMap(new WeakHashMap<Thread, T>());

    public void set(T newValue) {
        Thread key = Thread.currentThread();
        values.put(key, newValue);
    }

    public T get() {
        Thread key = Thread.currentThread();
        return values.get(key);
    }
}

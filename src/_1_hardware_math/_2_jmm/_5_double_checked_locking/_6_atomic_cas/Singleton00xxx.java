package _1_hardware_math._2_jmm._5_double_checked_locking._6_atomic_cas;

import java.util.concurrent.atomic.AtomicReference;

public class Singleton00xxx {
    private int state;

    private Singleton00xxx(int state) {
        this.state = state;
    }

    public int getState() {
        return this.state;
    }

    private static AtomicReference<Singleton00xxx> instance = new AtomicReference<>();

    public static Singleton00xxx getInstance() {
        Singleton00xxx tmp = instance.get();
        if (tmp == null) {
            tmp = new Singleton00xxx(1);
            instance.compareAndSet(null, tmp); // CAS
        }
        return tmp;
    }
}

class Demo {
    static volatile int x = 0;
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        while (x++ < 1_000_000_000);
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);
    }
}
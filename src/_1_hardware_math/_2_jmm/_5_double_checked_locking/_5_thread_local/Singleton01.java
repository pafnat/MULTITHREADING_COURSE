package _1_hardware_math._2_jmm._5_double_checked_locking._5_thread_local;

public class Singleton01 {
    private int state;
    private Singleton01(int state) {this.state = state;}
    public int getState() {return this.state;}

    private static ThreadLocal<Singleton01> instance = new ThreadLocal<>();
    public static Singleton01 getInstance() {
        if (instance.get() == null) {
            instance.set(new Singleton01(1));
        }
        return instance.get();
    }
}

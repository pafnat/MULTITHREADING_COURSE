package _1_hardware_math._2_jmm._5_double_checked_locking._5_thread_local;

public class Singleton00 {
    private int state;
    private Singleton00(int state) {this.state = state;}
    public int getState() {return this.state;}

    public static ThreadLocal<Singleton00> instance = new ThreadLocal<Singleton00>() {
        @Override
        protected Singleton00 initialValue() {
            return new Singleton00(1);
        }
    };
    public static Singleton00 getInstance() {
        return instance.get();
    }
}

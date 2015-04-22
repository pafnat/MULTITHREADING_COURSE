package _1_hardware_math._2_jmm._5_double_checked_locking._1_sync;

public class Singleton01 {
    public int state;
    private Singleton01(int state) {this.state = state;}
    public synchronized void setState(int state) {
        this.state = state;
    }

    private static Singleton01 instance;
    public synchronized static Singleton01 getInstance() {
        if (instance == null) {
            instance = new Singleton01(1);
        }
        return instance;
    }
}

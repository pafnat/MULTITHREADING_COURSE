package _1_hardware_math._2_jmm._5_double_checked_locking._2_holder;

// http://docs.oracle.com/javase/7/docs/technotes/guides/lang/cl-mt.html
public class Singleton00 {
    private int state;

    private Singleton00(int state) {
        this.state = state;
        System.out.println("new");
    }

    public int getState() {
        return state;
    }

    public static Singleton00 getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        private static Singleton00 instance = new Singleton00(1);
    }

//    private static Singleton00 instance = new Singleton00(1);

    public static void test() {
    }
}

class Test {
    public static void main(String[] args) {
//        Singleton00.test();
        Singleton00.getInstance();
    }
}


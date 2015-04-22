package _1_hardware_math._2_jmm._5_double_checked_locking._1_sync;

public class Singleton01_demo0 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Singleton01.getInstance().state); //1
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println(Singleton01.getInstance().state); //1
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println(Singleton01.getInstance().state); //1
            }
        }).start();
    }
}

//   -hb-> r
// w -hb-> r
//   -hb-> r
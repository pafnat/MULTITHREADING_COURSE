package _1_hardware_math._2_jmm._5_double_checked_locking._1_sync;

public class Singleton00_demo1 {
    public static void main(String[] args) {
        // "платим" за getInstance()
        Singleton00 instance = Singleton00.getInstance();
        // нет синхронизации
        System.out.println(instance.getState());
        // нет синхронизации
        System.out.println(instance.getState());
        // нет синхронизации
        System.out.println(instance.getState());
    }
}

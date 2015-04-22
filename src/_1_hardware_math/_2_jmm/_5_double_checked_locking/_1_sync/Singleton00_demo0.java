package _1_hardware_math._2_jmm._5_double_checked_locking._1_sync;

import java.util.Vector;

// uncontended lock - light lock = http://docs.huihoo.com/javaone/2006/java-se/TS-3412.pdf
// https://researchweb.watson.ibm.com/trl/people/kawatiya/pub/Kawachiya02oopsla.pdf // Lock Reservation: Java Locks Can Mostly Do Without Atomic Operations
// lock coersion
// escape analisis
public class Singleton00_demo0 {
    // Vector - > ArrayList
    // Hashtable - > HashMap
    // StringBuffer - > StringBuilder
    public static void main(String[] args) {
        // "платим" за getInstance()
        System.out.println(Singleton00.getInstance().getState());
        // "платим" за getInstance()
        System.out.println(Singleton00.getInstance().getState());
        // "платим" за getInstance()
        System.out.println(Singleton00.getInstance().getState());
    }
}

class T {
    public static Vector v = new Vector();

    public static void main(String[] args) {
        synchronized (v) {
            v.add("A");
            v.add("B");
            v.add("C");
        }
        System.out.println(v);
    }
}

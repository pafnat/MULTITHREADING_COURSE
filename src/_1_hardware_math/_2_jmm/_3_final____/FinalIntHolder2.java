package _1_hardware_math._2_jmm._3_final____;

public class FinalIntHolder2 {
    public int value; // поле НЕ final
    public final int finalValue; // поле final
    public FinalIntHolder2(int value, int finalValue) {
        this.value = value;
        this.finalValue = finalValue;
    }
}

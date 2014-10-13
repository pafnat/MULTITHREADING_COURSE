package hardware.cache_L2_size;

/*
    размер кэша L1
 */


public class CacheL2SizeDetector {

    public static void main(String[] args) {
        byte[] array = new byte[512 * 1024];

        for (int testIndex = 0; testIndex < 10; testIndex++) {
            testMethod(array);
            System.out.println("---");
        }
    }

    private static void testMethod(byte[] array) {
        for (int len = 64 * 1024; len <= array.length; len += 64 * 1024) {
            int sum = 0;

            long t0 = System.nanoTime();
            for (int n = 0; n < 1000; n++) {
                for (int index = 0; index < len; index += 64) {
                    array[index] = 1;
                }
            }
            long dT = System.nanoTime() - t0;

            if (sum > 0) {
                throw new Error();
            }

            System.out.println("len:" + len + ", dT: " + dT + ", 10*dT/len: " + (10 * dT) / len);
        }
    }

}

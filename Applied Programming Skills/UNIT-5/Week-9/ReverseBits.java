public class ReverseBits {
    public static void main(String[] args) {
        int n = 43261596;
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>= 1;
        }

        System.out.println(result);
    }
}
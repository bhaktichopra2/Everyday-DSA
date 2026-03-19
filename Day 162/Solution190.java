// 190. Reverse Bits

// Reverse bits of a given 32 bits signed integer.

public class Solution190 {

    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;           // shift result left
            result |= (n & 1);      // add last bit of n
            n >>= 1;                // shift n right
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 43261596; // example input
        System.out.println(reverseBits(n));
    }
}
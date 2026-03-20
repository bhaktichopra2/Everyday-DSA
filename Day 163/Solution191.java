// 191. Number of 1 Bits

// Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).

public class Solution191 {

    public static int hammingWeight(int n) {
        int count = 0;
        String binary = Integer.toBinaryString(n);

        for (char c : binary.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 11; // binary: 1011
        System.out.println(hammingWeight(n));
    }
}
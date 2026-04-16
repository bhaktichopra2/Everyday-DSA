// 461. Hamming Distance

// The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

// Given two integers x and y, return the Hamming distance between them.

public class Solution461 {

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 4;

        System.out.println(hammingDistance(x, y));
    }
}
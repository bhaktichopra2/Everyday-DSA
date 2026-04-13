// 342. Power of Four

// Given an integer n, return true if it is a power of four. Otherwise, return false.

// An integer n is a power of four, if there exists an integer x such that n == 4x.

public class Solution342 {

    public static boolean isPowerOfFour(int n) {
        return n > 0 &&
               (n & (n - 1)) == 0 &&
               n % 3 == 1;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfFour(n));
    }
}
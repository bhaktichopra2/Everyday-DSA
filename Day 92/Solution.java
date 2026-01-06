// 50. Pow(x, n)
// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
public class Solution {

    public double myPow(double x, int n) {
        long k = n;          // use long to avoid overflow when n == Integer.MIN_VALUE
        if (k < 0) {
            x = 1 / x;
            k = -k;
        }

        double pow = 1.0;
        while (k != 0) {
            if ((k & 1L) != 0) {
                pow *= x;
            }
            x *= x;
            k >>= 1;
        }
        return pow;
    }

    // Simple main to test in VS Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myPow(2.0, 10));   // 1024.0
        System.out.println(sol.myPow(2.0, -2));   // 0.25
        System.out.println(sol.myPow(2.1, 3));    // 9.261
    }
}

// 7. Reverse Integer
// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
class Solution {
    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int digit = x % 10;

            // Check for overflow before multiplying and adding
            if (res > Integer.MAX_VALUE / 10 ||
                (res == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 ||
                (res == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            res = res * 10 + digit;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverse(123));        // 321
        System.out.println(sol.reverse(-123));       // -321
        System.out.println(sol.reverse(120));        // 21
        System.out.println(sol.reverse(1534236469)); // 0 (overflow)
    }
}

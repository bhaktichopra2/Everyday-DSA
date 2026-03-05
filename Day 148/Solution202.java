// 202. Happy Number

// Write an algorithm to determine if a number n is happy.

// A happy number is a number defined by the following process:

// Starting with any positive integer, replace the number by the sum of the squares of its digits.
// Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
// Those numbers for which this process ends in 1 are happy.
// Return true if n is a happy number, and false if not.

import java.util.HashSet;
import java.util.Set;

public class Solution202 {

    public boolean isHappy(int n) {
        Set<Integer> vis = new HashSet<>();

        while (n != 1 && !vis.contains(n)) {
            vis.add(n);
            n = sumOfSquares(n);
        }

        return n == 1;
    }

    private int sumOfSquares(int n) {
        int res = 0;

        while (n > 0) {
            int digit = n % 10;   // get last digit
            res += digit * digit;
            n /= 10;              // remove last digit
        }

        return res;
    }

    // ---- Test Main for VS Code ----
    public static void main(String[] args) {
        Solution202 sol = new Solution202();

        int n = 19;
        System.out.println(sol.isHappy(n));  // true
    }
}
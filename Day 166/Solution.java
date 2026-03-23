// 1312. Minimum Insertion Steps to Make a String Palindrome

// Given a string s. In one step you can insert any character at any index of the string.

// Return the minimum number of steps to make s palindrome.

// A Palindrome String is one that reads the same backward as well as forward.

 public class Solution {

    public int minInsertions(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int prev = 0;

            for (int j = 1; j <= n; j++) {
                int temp = dp[j];

                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[j] = 1 + prev;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                prev = temp;
            }
        }

        return n - dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abcaa";

        System.out.println(sol.minInsertions(s));
    }
}
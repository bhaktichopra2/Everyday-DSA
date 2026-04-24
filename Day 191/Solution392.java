// 392. Is Subsequence

// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

public class Solution392 {

    public static boolean isSubsequence(String s, String t) {
        int i = 0;

        for (int j = 0; j < t.length(); j++) {
            if (i < s.length() && s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        String s = "ace";
        String t = "abcde";

        System.out.println(isSubsequence(s, t));
    }
}
// 3. Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without duplicate characters.

import java.util.Arrays;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int HashLen = 256;
        int[] hash = new int[HashLen];
        
        Arrays.fill(hash, -1);
        
        int l = 0, r = 0, maxLen = 0;
        while (r < n) {
            if (hash[s.charAt(r)] >= l) {
                l = Math.max(hash[s.charAt(r)] + 1, l);
            }
            int len = r - l + 1;
            maxLen = Math.max(len, maxLen);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));     // 3
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));       // 1
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));      // 3
        System.out.println(sol.lengthOfLongestSubstring(""));            // 0
        System.out.println(sol.lengthOfLongestSubstring("dvdf"));        // 3
    }
}

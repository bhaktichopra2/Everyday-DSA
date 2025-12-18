// 387. First Unique Character in a String
// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        // Find first index with frequency 1
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }

    // For VS Code testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.firstUniqChar("leetcode"));     // 0
        System.out.println(sol.firstUniqChar("loveleetcode")); // 2
        System.out.println(sol.firstUniqChar("aabb"));         // -1
    }
}

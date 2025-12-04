// 58. Length of Last Word
// Given a string s consisting of words and spaces, return the length of the last word in the string.

// A word is a maximal substring consisting of non-space characters only.
public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim(); // Remove trailing and leading spaces
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLastWord("Hello World"));          // 5
        System.out.println(sol.lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(sol.lengthOfLastWord("luffy is still joyboy")); // 6
        System.out.println(sol.lengthOfLastWord("   ")); // 0 or error depending on problem constraints
    }
}

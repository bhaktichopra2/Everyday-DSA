// 520. Detect Capital
// We define the usage of capitals in a word to be right when one of the following cases holds:

// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".
// Given a string word, return true if the usage of capitals in it is right.
class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                count++;
            }
        }

        if (count == word.length() || count == 0) {
            return true;
        }
        if (count == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        return false;
    }

    // For VS Code testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.detectCapitalUse("USA"));     // true
        System.out.println(sol.detectCapitalUse("leetcode")); // true
        System.out.println(sol.detectCapitalUse("Google"));   // true
        System.out.println(sol.detectCapitalUse("FlaG"));     // false
    }
}

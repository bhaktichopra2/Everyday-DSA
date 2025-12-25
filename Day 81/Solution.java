// 557. Reverse Words in a String III
// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
class Solution {
    public String reverseWords(String s) {
        // Split on single spaces (input uses single spaces between words)
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder w = new StringBuilder(words[i]);
            sb.append(w.reverse());
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("Let's take LeetCode contest"));
        // s'teL ekat edoCteeL tsetnoc
        System.out.println(sol.reverseWords("Mr Ding"));
        // rM gniD
    }
}

// 1328. Break a Palindrome
// Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.

// Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.

// A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.

class Solution {
    public String breakPalindrome(String palindrome) {
        char[] array = palindrome.toCharArray();
        int n = palindrome.length();

        if(n == 1) return "";

        for(int i = 0; i < n/2; i++){
            if(array[i] != 'a'){
                array[i] = 'a';
                return String.valueOf(array);
            }
        }
        array[n-1] = 'b';
        return new String(array);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] tests = {"abccba", "a", "aaa"};
        
        for (String test : tests) {
            String result = sol.breakPalindrome(test);
            System.out.println("Input: " + test + " -> Output: " + result);
        }
    }
}

// 9. Palindrome Number
// Given an integer x, return true if x is a palindrome, and false otherwise.
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        String num = String.valueOf(x);
        int l = 0;
        int r = num.length() - 1;
        
        while (l < r) {
            if (num.charAt(l) != num.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    // Test block for VSCode
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(121));  // true
        System.out.println(s.isPalindrome(-121)); // false
        System.out.println(s.isPalindrome(10));   // false
    }
}

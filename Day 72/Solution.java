// 344. Reverse String
// Write a function that reverses a string. The input string is given as an array of characters s.
// You must do this by modifying the input array in-place with O(1) extra memory.import java.util.Arrays;
import java.util.*;

class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        char temp;
        for (int i = 0; i < n / 2; i++) {
            temp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        sol.reverseString(arr);
        System.out.println(Arrays.toString(arr)); // [o, l, l, e, h]
    }
}

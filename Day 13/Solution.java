// 784. Letter Case Permutation
// Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

// Return a list of all possible strings we could create. Return the output in any order
import java.util.*;

public class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> output = new ArrayList<>();
        output.add("");

        for (char c : s.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (String currentStr : output) {
                if (Character.isLetter(c)) {
                    temp.add(currentStr + Character.toLowerCase(c));
                    temp.add(currentStr + Character.toUpperCase(c));
                } else {
                    temp.add(currentStr + c);
                }
            }
            output = temp;
        }
        return output;
    }

    // Runnable main for VS Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        String test = "a1b2";
        List<String> result = sol.letterCasePermutation(test);
        System.out.println(result); // Output example: [a1b2, a1B2, A1b2, A1B2]
    }
}

// 20. Valid Parentheses
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');
        
        for (char ch : s.toCharArray()) {
            if (mapping.containsKey(ch)) {
                // Closing bracket
                if (stack.isEmpty() || stack.pop() != mapping.get(ch)) {
                    return false;
                }
            } else {
                // Opening bracket
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    // Test block
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()"));           // true
        System.out.println(s.isValid("()[]{}"));       // true
        System.out.println(s.isValid("(]"));           // false
        System.out.println(s.isValid("([)]"));         // false
    }
}

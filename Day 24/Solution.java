// 20. Valid Parentheses
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.

import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != map.get(ch)) return false;
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    // Test harness for VS Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        String test1 = "()[]{}";
        String test2 = "(]";
        System.out.println(sol.isValid(test1)); // true
        System.out.println(sol.isValid(test2)); // false
    }
}

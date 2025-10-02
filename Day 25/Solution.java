// 150. Evaluate Reverse Polish Notation
// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

// Evaluate the expression. Return an integer that represents the value of the expression.

// Note that:

// The valid operators are '+', '-', '*', and '/'.
// Each operand may be an integer or another expression.
// The division between two integers always truncates toward zero.
// There will not be any division by zero.
// The input represents a valid arithmetic expression in a reverse polish notation.
// The answer and all the intermediate calculations can be represented in a 32-bit integer.

import java.util.*;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int r = stack.pop();
                int l = stack.pop();
                int res;
                switch (t) {
                    case "+": res = l + r; break;
                    case "-": res = l - r; break;
                    case "*": res = l * r; break;
                    default:  res = l / r; break; // Java truncates towards zero
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }

    // Test harness for VS Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] test = {"2", "1", "+", "3", "*"}; // (2+1)*3 = 9
        String[] test2 = {"4", "13", "5", "/", "+"}; // 4 + (13/5) = 6
        System.out.println(sol.evalRPN(test));  // Output: 9
        System.out.println(sol.evalRPN(test2)); // Output: 6
    }
}

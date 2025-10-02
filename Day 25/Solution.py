# 150. Evaluate Reverse Polish Notation
# You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

# Evaluate the expression. Return an integer that represents the value of the expression.

# Note that:

# The valid operators are '+', '-', '*', and '/'.
# Each operand may be an integer or another expression.
# The division between two integers always truncates toward zero.
# There will not be any division by zero.
# The input represents a valid arithmetic expression in a reverse polish notation.
# The answer and all the intermediate calculations can be represented in a 32-bit integer.

from typing import List

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for t in tokens:
            if t not in '+-*/':
                stack.append(int(t))
            else:
                r = stack.pop()
                l = stack.pop()
                if t == "+":
                    stack.append(l + r)
                elif t == "-":
                    stack.append(l - r)
                elif t == "*":
                    stack.append(l * r)
                else:
                    # Python division result and truncate toward zero
                    stack.append(int(l / r))
        return stack.pop()

if __name__ == "__main__":
    sol = Solution()
    test = ["2", "1", "+", "3", "*"]         # Expects 9
    test2 = ["4", "13", "5", "/", "+"]       # Expects 6
    print(sol.evalRPN(test))
    print(sol.evalRPN(test2))

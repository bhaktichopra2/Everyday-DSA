# 20. Valid Parentheses
# Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

# An input string is valid if:

# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.
# Every close bracket has a corresponding open bracket of the same type.
from typing import Optional

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mapping = {')': '(', '}': '{', ']': '['}
        
        for char in s:
            if char in mapping:
                # Closing bracket
                if not stack or stack.pop() != mapping[char]:
                    return False
            else:
                # Opening bracket
                stack.append(char)
        
        return len(stack) == 0

# Test block
if __name__ == "__main__":
    s = Solution()
    print(s.isValid("()"))       # True
    print(s.isValid("()[]{}"))   # True
    print(s.isValid("(]"))       # False
    print(s.isValid("([)]"))     # False

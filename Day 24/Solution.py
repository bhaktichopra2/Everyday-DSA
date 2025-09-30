# 20. Valid Parentheses
# Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

# An input string is valid if:

# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.
# Every close bracket has a corresponding open bracket of the same type.

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        hashmap = {')': '(', '}': '{', ']': '['}

        for ele in s:
            if stack and ele in hashmap and stack[-1] == hashmap[ele]:
                stack.pop()
            else:
                stack.append(ele)
        return not stack

# Test harness for VS Code
if __name__ == "__main__":
    sol = Solution()
    test1 = "()[]{}"
    test2 = "(]"
    print(sol.isValid(test1))  # True
    print(sol.isValid(test2))  # False

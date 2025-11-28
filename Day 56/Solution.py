# 9. Palindrome Number
# Given an integer x, return true if x is a palindrome, and false otherwise.
from typing import Optional

class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        
        num = str(x)
        l, r = 0, len(num) - 1
        
        while l < r:
            if num[l] != num[r]:
                return False
            l += 1
            r -= 1
        return True

# Test block for VSCode
if __name__ == "__main__":
    s = Solution()
    print(s.isPalindrome(121))    # True
    print(s.isPalindrome(-121))   # False
    print(s.isPalindrome(10))     # False

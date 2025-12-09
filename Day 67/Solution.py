# 125. Valid Palindrome
# A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

# Given a string s, return true if it is a palindrome, or false otherwise.
class Solution:
    def isPalindrome(self, s: str) -> bool:
        left, right = 0, len(s) - 1
        
        while left < right:
            # Skip non-alphanumeric from left
            while left < right and not s[left].isalnum():
                left += 1
            # Skip non-alphanumeric from right
            while left < right and not s[right].isalnum():
                right -= 1
            
            # Compare ignoring case
            if s[left].lower() != s[right].lower():
                return False
            left += 1
            right -= 1
        
        return True

if __name__ == "__main__":
    sol = Solution()
    
    # Test case 1
    print(sol.isPalindrome("A man, a plan, a canal: Panama"))  # True
    
    # Test case 2
    print(sol.isPalindrome("race a car"))  # False
    
    # Test case 3
    print(sol.isPalindrome(" "))  # True

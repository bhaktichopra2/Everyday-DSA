# 1328. Break a Palindrome
# Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.

# Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.

# A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.
class Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        array = list(palindrome)
        n = len(palindrome)

        if n == 1:
            return ""

        for i in range(n//2):
            if array[i] != 'a':
                array[i] = 'a'
                return ''.join(array)
        
        array[-1] = 'b'
        return ''.join(array)

# Test cases
if __name__ == "__main__":
    sol = Solution()
    tests = ["abccba", "a", "aaa"]
    
    for test in tests:
        result = sol.breakPalindrome(test)
        print(f"Input: {test} -> Output: {result}")

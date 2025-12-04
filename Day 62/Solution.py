# 58. Length of Last Word
# Given a string s consisting of words and spaces, return the length of the last word in the string.

# A word is a maximal substring consisting of non-space characters only.
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        return len(s.rstrip().split()[-1]) if s.strip() else 0

# Test cases
if __name__ == "__main__":
    s = Solution()
    print(s.lengthOfLastWord("Hello World"))          # 5
    print(s.lengthOfLastWord("   fly me   to   the moon  ")) # 4
    print(s.lengthOfLastWord("luffy is still joyboy")) # 6
    print(s.lengthOfLastWord("   "))                  # 0

# 520. Detect Capital
# We define the usage of capitals in a word to be right when one of the following cases holds:

# All letters in this word are capitals, like "USA".
# All letters in this word are not capitals, like "leetcode".
# Only the first letter in this word is capital, like "Google".
# Given a string word, return true if the usage of capitals in it is right.

class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        count = 0
        for ch in word:
            if ch.isupper():
                count += 1

        if count == len(word) or count == 0:
            return True
        if count == 1 and word[0].isupper():
            return True
        return False

if __name__ == "__main__":
    sol = Solution()
    print(sol.detectCapitalUse("USA"))      # True
    print(sol.detectCapitalUse("leetcode")) # True
    print(sol.detectCapitalUse("Google"))   # True
    print(sol.detectCapitalUse("FlaG"))     # False

# 383. Ransom Note
# Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

# Each letter in magazine can only be used once in ransomNote.
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        freq = [0] * 26  # for 'a' to 'z'

        for ch in magazine:
            freq[ord(ch) - ord('a')] += 1

        for ch in ransomNote:
            idx = ord(ch) - ord('a')
            freq[idx] -= 1
            if freq[idx] < 0:
                return False

        return True

if __name__ == "__main__":
    sol = Solution()
    print(sol.canConstruct("aa", "ab"))   # False
    print(sol.canConstruct("aa", "aab"))  # True


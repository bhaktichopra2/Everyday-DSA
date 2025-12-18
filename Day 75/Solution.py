# 387. First Unique Character in a String
# Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
from typing import Dict

class Solution:
    def firstUniqChar(self, s: str) -> int:
        freq: Dict[str, int] = {}

        # Count frequency of each character
        for ch in s:
            freq[ch] = freq.get(ch, 0) + 1

        # Find first index with frequency 1
        for i, ch in enumerate(s):
            if freq[ch] == 1:
                return i
        return -1

if __name__ == "__main__":
    sol = Solution()
    print(sol.firstUniqChar("leetcode"))      # 0
    print(sol.firstUniqChar("loveleetcode"))  # 2
    print(sol.firstUniqChar("aabb"))          # -1

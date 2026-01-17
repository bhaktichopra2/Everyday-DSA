# 3. Longest Substring Without Repeating Characters
# Given a string s, find the length of the longest substring without duplicate characters.
from typing import List

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        HashLen = 256
        hash = [-1] * HashLen
        
        l, r, maxLen = 0, 0, 0
        while r < n:
            if hash[ord(s[r])] >= l:  # Fixed: check >= l like Java
                l = max(hash[ord(s[r])] + 1, l)
            
            current_len = r - l + 1
            maxLen = max(current_len, maxLen)
            hash[ord(s[r])] = r
            r += 1
        return maxLen

if __name__ == "__main__":
    sol = Solution()
    print(sol.lengthOfLongestSubstring("abcabcbb"))  # 3
    print(sol.lengthOfLongestSubstring("bbbbb"))    # 1
    print(sol.lengthOfLongestSubstring("pwwkew"))   # 3
    print(sol.lengthOfLongestSubstring(""))          # 0
    print(sol.lengthOfLongestSubstring("dvdf"))     # 3

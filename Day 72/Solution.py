# 344. Reverse String
# Write a function that reverses a string. The input string is given as an array of characters s.
# You must do this by modifying the input array in-place with O(1) extra memory.
from typing import List

class Solution:
    def reverseString(self, s: List[str]) -> None:
        n = len(s)
        for i in range(n // 2):
            s[i], s[n - i - 1] = s[n - i - 1], s[i]

if __name__ == "__main__":
    sol = Solution()
    arr = ["h", "e", "l", "l", "o"]
    sol.reverseString(arr)
    print(arr)  # ['o', 'l', 'l', 'e', 'h']

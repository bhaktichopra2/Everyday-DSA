# 771. Jewels and Stones
# You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

# Letters are case sensitive, so "a" is conside
# red a different type of stone from "A".
class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        jewel_set = set(jewels)  # O(m)
        count = 0
        for ch in stones:        # O(n)
            if ch in jewel_set:
                count += 1
        return count

if __name__ == "__main__":
    sol = Solution()
    print(sol.numJewelsInStones("aA", "aAAbbbb"))  # 3
    print(sol.numJewelsInStones("z", "ZZ"))        # 0

# 60. Permutation Sequence
# The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

# By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

# "123"
# "132"
# "213"
# "231"
# "312"
# "321"
# Given n and k, return the kth permutation sequence.

from typing import List

class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        fact = 1
        numbers = []
        
        # Calculate (n-1)! and populate numbers 1 to n
        for i in range(1, n):
            fact *= i
            numbers.append(i)
        numbers.append(n)
        
        k -= 1  # 0-indexed
        ans = []
        
        while numbers:  # Loop until empty
            idx = k // fact
            ans.append(str(numbers.pop(idx)))  # Remove in one step
            
            k %= fact
            if numbers:  # ✅ FIX: Check before divide!
                fact //= len(numbers)
        
        return ''.join(ans)
    
    # VSCode Test
    def test(self):
        sol = Solution()
        print(sol.getPermutation(3, 3))   # "213"
        print(sol.getPermutation(4, 9))   # "2314"
        print(sol.getPermutation(1, 1))   # "1"

if __name__ == "__main__":
    Solution().test()

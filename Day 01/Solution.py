from typing import List

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        l = 0
        r = len(numbers) - 1
        while l < r:
            s = numbers[l] + numbers[r]
            if s == target:
                return [l + 1, r + 1]
            elif s < target:
                l += 1
            else:
                r -= 1
        return [-1, -1]

# Example usage/test
if __name__ == "__main__":
    solution = Solution()
    numbers = [2, 7, 11, 15]
    target = 9
    result = solution.twoSum(numbers, target)
    print("Indices:", result)  # Output: Indices: [1, 2]

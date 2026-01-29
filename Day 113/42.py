# 42. Trapping Rain Water
# Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        
        left, right = 0, n - 1
        
        max_left = 0
        max_right = 0
        
        total_water = 0
        
        while left <= right:
            if height[left] <= height[right]:
                if height[left] >= max_left:
                    max_left = height[left]
                else:
                    total_water += max_left - height[left]
                left += 1  
            else:
                if height[right] >= max_right:
                    max_right = height[right]
                else:
                    total_water += max_right - height[right]
                right -= 1  
        
        return total_water

# Test cases
if __name__ == "__main__":
    sol = Solution()
    height1 = [0,1,0,2,1,0,1,3,2,1,2,1]
    height2 = [4,2,0,3,2,5]
    
    print("Test 1:", sol.trap(height1))  # 6
    print("Test 2:", sol.trap(height2))  # 9

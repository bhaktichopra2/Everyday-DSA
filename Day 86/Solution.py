# 118. Pascal's Triangle
# Given an integer numRows, return the first numRows of Pascal's triangle.

# In Pascal's triangle, each number is the sum of the two numbers directly above it

from typing import List

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        triangle = []
        
        # Loop for each row
        for i in range(numRows):
            # Create row with size (i+1), all 1s
            row = [1] * (i + 1)
            
            # Fill middle elements (from index 1 to i-1)
            for j in range(1, i):
                # Each element = sum of two elements above it
                row[j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
            
            # Add current row to triangle
            triangle.append(row)
        
        return triangle

if __name__ == "__main__":
    sol = Solution()
    
    # Test with 5 rows
    result = sol.generate(5)
    
    print("Pascal's Triangle:")
    for row in result:
        print(row)
    # Output:
    # [1]
    # [1, 1]
    # [1, 2, 1]
    # [1, 3, 3, 1]
    # [1, 4, 6, 4, 1]

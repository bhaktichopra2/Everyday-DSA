# 784. Letter Case Permutation
# Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

# Return a list of all possible strings we could create. Return the output in any order
from typing import List

class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        output = [""]
        for c in s:
            temp = []
            if c.isalpha():
                for o in output:
                    temp.append(o + c.lower())
                    temp.append(o + c.upper())
            else:
                for o in output:
                    temp.append(o + c)
            output = temp
        return output

# Runnable test for VS Code
if __name__ == "__main__":
    sol = Solution()
    test = "a1b2"
    result = sol.letterCasePermutation(test)
    print(result) # Output example: ['a1b2', 'a1B2', 'A1b2', 'A1B2']

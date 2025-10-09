# 682. Baseball Game
# You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.

# You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:

# An integer x.
# Record a new score of x.
# '+'.
# Record a new score that is the sum of the previous two scores.
# 'D'.
# Record a new score that is the double of the previous score.
# 'C'.
# Invalidate the previous score, removing it from the record.
# Return the sum of all the scores on the record after applying all the operations.

# The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.
from typing import List

class Solution:
    def calPoints(self, operations: List[str]) -> int:
        score = []
        for op in operations:
            if op == "+":
                score.append(score[-1] + score[-2])
            elif op == "D":
                score.append(score[-1] * 2)
            elif op == "C":
                score.pop()
            else:
                score.append(int(op))
        return sum(score)

# Testing block for VSCode
if __name__ == "__main__":
    solution = Solution()
    operations = ["5", "2", "C", "D", "+"]
    print(solution.calPoints(operations))  # Expected: 30

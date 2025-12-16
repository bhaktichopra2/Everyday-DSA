# 374. Guess Number Higher or Lower
# We are playing the Guess Game. The game is as follows:

# I pick a number from 1 to n. You have to guess which number I picked (the number I picked stays the same throughout the game).

# Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

# You call a pre-defined API int guess(int num), which returns three possible results:

# -1: Your guess is higher than the number I picked (i.e. num > pick).
# 1: Your guess is lower than the number I picked (i.e. num < pick).
# 0: your guess is equal to the number I picked (i.e. num == pick).
# Return the number that I picked.

class GuessGame:
    def __init__(self, pick: int):
        self.pick = pick

    # API: returns -1 if num is higher, 1 if num is lower, 0 if correct
    def guess(self, num: int) -> int:
        if num > self.pick:
            return -1
        if num < self.pick:
            return 1
        return 0


class Solution(GuessGame):
    def __init__(self, pick: int):
        super().__init__(pick)

    def guessNumber(self, n: int) -> int:
        start, end = 1, n

        while start <= end:
            mid = start + (end - start) // 2
            res = self.guess(mid)
            if res == 0:
                return mid
            elif res == 1:      # mid is lower than pick
                start = mid + 1
            else:               # res == -1, mid is higher than pick
                end = mid - 1
        return -1


if __name__ == "__main__":
    n = 100
    pick = 73
    sol = Solution(pick)
    print(sol.guessNumber(n))  # prints 73

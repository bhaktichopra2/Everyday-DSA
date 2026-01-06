# 50. Pow(x, n)
# Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
class Solution:
    def myPow(self, x: float, n: int) -> float:
        k = n
        if k < 0:
            x = 1 / x
            k = -k

        pow_val = 1.0
        while k != 0:
            if k & 1:
                pow_val *= x
            x *= x
            k >>= 1
        return pow_val


if __name__ == "__main__":
    sol = Solution()
    print(sol.myPow(2.0, 10))   # 1024.0
    print(sol.myPow(2.0, -2))   # 0.25
    print(sol.myPow(2.1, 3))    # 9.261

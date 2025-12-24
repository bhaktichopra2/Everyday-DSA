# 7. Reverse Integer
# Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

# Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
class Solution:
    def reverse(self, x: int) -> int:
        res = 0
        sign = -1 if x < 0 else 1
        x = abs(x)

        while x != 0:
            digit = x % 10
            x //= 10
            res = res * 10 + digit

        res *= sign

        # 32-bit signed range check
        if -2**31 <= res <= 2**31 - 1:
            return res
        return 0


if __name__ == "__main__":
    sol = Solution()
    print(sol.reverse(123))        # 321
    print(sol.reverse(-123))       # -321
    print(sol.reverse(120))        # 21
    print(sol.reverse(1534236469)) # 0 (overflow)

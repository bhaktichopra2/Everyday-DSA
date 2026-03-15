# 326. Power of Three

# Given an integer n, return true if it is a power of three. Otherwise, return false.

# An integer n is a power of three, if there exists an integer x such that n == 3x.

def isPowerOfThree(n: int) -> bool:
    if n <= 0:
        return False

    while n % 3 == 0:
        n //= 3

    return n == 1


def main():
    n = 27
    print(isPowerOfThree(n))


if __name__ == "__main__":
    main()
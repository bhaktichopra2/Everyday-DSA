# 231. Power of Two

# Given an integer n, return true if it is a power of two. Otherwise, return false.

# An integer n is a power of two, if there exists an integer x such that n == 2x.

def isPowerOfTwo(n: int) -> bool:
    return n > 0 and (n & (n - 1)) == 0


def main():
    n = 16

    result = isPowerOfTwo(n)

    print("Is power of two:", result)


if __name__ == "__main__":
    main()
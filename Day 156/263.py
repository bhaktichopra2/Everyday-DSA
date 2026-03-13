# 263. Ugly Number

# An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.

# Given an integer n, return true if n is an ugly number.

def isUgly(n):
    if n <= 0:
        return False

    for f in [2, 3, 5]:
        while n % f == 0:
            n //= f

    return n == 1


def main():
    n = 8
    print(isUgly(n))


if __name__ == "__main__":
    main()
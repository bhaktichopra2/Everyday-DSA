# 461. Hamming Distance

# The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

# Given two integers x and y, return the Hamming distance between them.

def hammingDistance(x: int, y: int) -> int:
    return bin(x ^ y).count('1')


def main():
    x = 1
    y = 4

    print(hammingDistance(x, y))


if __name__ == "__main__":
    main()
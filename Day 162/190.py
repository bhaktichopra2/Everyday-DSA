# 190. Reverse Bits

# Reverse bits of a given 32 bits signed integer.

def reverseBits(n: int) -> int:
    result = 0

    for _ in range(32):
        result <<= 1
        result |= (n & 1)
        n >>= 1

    return result


def main():
    n = 43261596
    print(reverseBits(n))


if __name__ == "__main__":
    main()
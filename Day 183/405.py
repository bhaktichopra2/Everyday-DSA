# 405. Convert a Number to Hexadecimal

# Given a 32-bit integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

# All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

# Note: You are not allowed to use any built-in library method to directly solve this problem.

def toHex(num: int) -> str:
    if num == 0:
        return "0"

    # handle negative numbers as 32-bit unsigned
    num &= 0xffffffff

    chars = "0123456789abcdef"
    result = []

    while num:
        result.append(chars[num & 15])
        num >>= 4

    return "".join(reversed(result))


def main():
    num = 26
    print(toHex(num))


if __name__ == "__main__":
    main()
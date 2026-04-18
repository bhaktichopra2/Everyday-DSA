# 67. Add Binary

# Given two binary strings a and b, return their sum as a binary string.

def addBinary(a: str, b: str) -> str:
    return bin(int(a, 2) + int(b, 2))[2:]


def main():
    a = "1010"
    b = "1011"

    print(addBinary(a, b)) #10101


if __name__ == "__main__":
    main()
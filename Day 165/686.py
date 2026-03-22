# 686. Repeated String Match

# Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.

# Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".

import math

def repeatedStringMatch(a: str, b: str) -> int:

    if b == "":
        return 0

    # minimum repeats needed
    q = math.ceil(len(b) / len(a))

    # check q and q+1
    for i in range(2):
        if b in a * (q + i):
            return q + i

    return -1


def main():
    a = "abcd"
    b = "cdabcdab"

    print(repeatedStringMatch(a, b))


if __name__ == "__main__":
    main()
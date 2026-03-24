# 38. Count and Say

# The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

# countAndSay(1) = "1"
# countAndSay(n) is the run-length encoding of countAndSay(n - 1).
# Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

# Given a positive integer n, return the nth element of the count-and-say sequence.

def countAndSay(n: int) -> str:
    result = "1"

    for _ in range(1, n):
        current = ""
        count = 1

        for j in range(1, len(result)):
            if result[j] == result[j - 1]:
                count += 1
            else:
                current += str(count) + result[j - 1]
                count = 1

        current += str(count) + result[-1]
        result = current

    return result


def main():
    n = 5
    print(countAndSay(n))


if __name__ == "__main__":
    main()
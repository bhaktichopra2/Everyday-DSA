# 168. Excel Sheet Column Title

# Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

def convertToTitle(columnNumber):
    result = []

    while columnNumber > 0:
        columnNumber -= 1
        result.append(chr(columnNumber % 26 + ord('A')))
        columnNumber //= 26

    return ''.join(result[::-1])


def main():
    print(convertToTitle(1))    # A
    print(convertToTitle(28))   # AB
    print(convertToTitle(701))  # ZY


if __name__ == "__main__":
    main()
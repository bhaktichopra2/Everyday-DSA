# 171. Excel Sheet Column Number


# Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

def titleToNumber(columnTitle):
    result = 0

    for ch in columnTitle:
        result = result * 26 + (ord(ch) - ord('A') + 1)

    return result


def main():
    print(titleToNumber("A"))    # 1
    print(titleToNumber("AB"))   # 28
    print(titleToNumber("ZY"))   # 701


if __name__ == "__main__":
    main()
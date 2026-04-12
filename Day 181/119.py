# 119. Pascal's Triangle II

# Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

# In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

def getRow(rowIndex):
    row = [1]

    for i in range(1, rowIndex + 1):
        next_element = row[i - 1] * (rowIndex - i + 1) // i
        row.append(next_element)

    return row


def main():
    rowIndex = 4
    print(getRow(rowIndex))


if __name__ == "__main__":
    main()
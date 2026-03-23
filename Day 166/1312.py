# 1312. Minimum Insertion Steps to Make a String Palindrome

# Given a string s. In one step you can insert any character at any index of the string.

# Return the minimum number of steps to make s palindrome.

# A Palindrome String is one that reads the same backward as well as forward.

def minInsertions(s: str) -> int:
    n = len(s)
    rev = s[::-1]

    dp = [0] * (n + 1)

    for i in range(1, n + 1):
        prev = 0
        for j in range(1, n + 1):
            temp = dp[j]

            if s[i - 1] == rev[j - 1]:
                dp[j] = 1 + prev
            else:
                dp[j] = max(dp[j], dp[j - 1])

            prev = temp

    return n - dp[n]


def main():
    s = "abcaa"
    print("Minimum insertions:", minInsertions(s))


if __name__ == "__main__":
    main()
# 8. String to Integer (atoi)

# Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

# The algorithm for myAtoi(string s) is as follows:

# Whitespace: Ignore any leading whitespace (" ").
# Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
# Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
# Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
# Return the integer as the final result.

def myAtoi(s: str) -> int:
    
    if not s:
        return 0

    s = s.strip()

    if len(s) == 0:   # 🔥 IMPORTANT FIX
        return 0

    sign = 1
    i = 0
    res = 0

    # Handle sign
    if s[i] == '+' or s[i] == '-':
        if s[i] == '-':
            sign = -1
        i += 1

    # Convert digits
    while i < len(s):
        ch = s[i]

        if ch < '0' or ch > '9':
            break

        res = res * 10 + (ord(ch) - ord('0'))

        # Overflow handling
        if sign * res > 2**31 - 1:
            return 2**31 - 1
        if sign * res < -2**31:
            return -2**31

        i += 1

    return sign * res


def main():
    print(myAtoi("   -42"))
    print(myAtoi("   "))
    print(myAtoi("4193 with words"))
    print(myAtoi("-91283472332"))
    print(myAtoi("hi2332"))


if __name__ == "__main__":
    main()
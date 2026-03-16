# 28. Find the Index of the First

# Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

def strStr(haystack: str, needle: str) -> int:
    return haystack.find(needle)


def main():
    haystack = "sadbutsad"
    needle = "sad"

    print(strStr(haystack, needle))


if __name__ == "__main__":
    main()
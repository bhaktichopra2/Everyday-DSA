# 165. Compare Version Numbers

# Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'. The value of the revision is its integer conversion ignoring leading zeros.

# To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, treat the missing revision values as 0.

# Return the following:

# If version1 < version2, return -1.
# If version1 > version2, return 1.
# Otherwise, return 0.

def compareVersion(version1: str, version2: str) -> int:

    v1 = version1.split('.')
    v2 = version2.split('.')

    n = max(len(v1), len(v2))

    for i in range(n):
        num1 = int(v1[i]) if i < len(v1) else 0
        num2 = int(v2[i]) if i < len(v2) else 0

        if num1 < num2:
            return -1
        elif num1 > num2:
            return 1

    return 0


def main():
    version1 = "1.0.1"
    version2 = "1"

    print(compareVersion(version1, version2))


if __name__ == "__main__":
    main()
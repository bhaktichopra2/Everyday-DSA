# 278. First Bad Version

# You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

# Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

# You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

def isBadVersion(version: int) -> bool:
    first_bad = 4   # example
    return version >= first_bad


class Solution:
    def firstBadVersion(self, n: int) -> int:
        l = 1
        h = n

        while l <= h:
            mid = l + (h - l) // 2

            if isBadVersion(mid):
                h = mid - 1
            else:
                l = mid + 1

        return l


def main():
    sol = Solution()
    n = 5
    print("First bad version:", sol.firstBadVersion(n))


if __name__ == "__main__":
    main()
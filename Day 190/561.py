# 561. Array Partition

# Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

def arrayPairSum(nums):
    nums.sort()

    total = 0

    # take every second element
    for i in range(0, len(nums), 2):
        total += nums[i]

    return total


def main():
    nums = [1, 4, 3, 2]
    print(arrayPairSum(nums))


if __name__ == "__main__":
    main()
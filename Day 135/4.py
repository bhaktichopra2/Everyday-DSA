# 4. Median of Two Sorted Arrays

# Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

# The overall run time complexity should be O(log (m+n)).

def find_median_sorted_arrays(nums1, nums2):

    # Ensure nums1 is the smaller array
    if len(nums2) < len(nums1):
        return find_median_sorted_arrays(nums2, nums1)

    n1, n2 = len(nums1), len(nums2)
    low, high = 0, n1

    while low <= high:
        cut1 = (low + high) // 2
        cut2 = (n1 + n2 + 1) // 2 - cut1

        left1  = float('-inf') if cut1 == 0 else nums1[cut1 - 1]
        left2  = float('-inf') if cut2 == 0 else nums2[cut2 - 1]

        right1 = float('inf') if cut1 == n1 else nums1[cut1]
        right2 = float('inf') if cut2 == n2 else nums2[cut2]

        if left1 <= right2 and left2 <= right1:
            if (n1 + n2) % 2 == 0:
                return (max(left1, left2) + min(right1, right2)) / 2.0
            else:
                return max(left1, left2)

        elif left1 > right2:
            high = cut1 - 1
        else:
            low = cut1 + 1

    return 0.0


# Optional test
if __name__ == "__main__":
    nums1 = [1, 3]
    nums2 = [2]
    print(find_median_sorted_arrays(nums1, nums2))  # Output: 2.0
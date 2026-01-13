# 493. Reverse Pairs (#Solved)
# Given an integer array nums, return the number of reverse pairs in the array.

# A reverse pair is a pair (i, j) where:

# 0 <= i < j < nums.length and
# nums[i] > 2 * nums[j].

class Solution:
    def reversePairs(self, nums):
        def mergeSort(low, high):
            if low >= high:
                return 0
            
            mid = (low + high) // 2
            invCount = mergeSort(low, mid) + mergeSort(mid + 1, high)
            
            # Count reverse pairs
            invCount += reverse_pairs(low, mid, high)
            
            # Merge
            merge(low, mid, high)
            
            return invCount
        
        def merge(low, mid, high):
            temp = []
            left, right = low, mid + 1
            
            while left <= mid and right <= high:
                if nums[left] <= nums[right]:
                    temp.append(nums[left])
                    left += 1
                else:
                    temp.append(nums[right])
                    right += 1
            
            temp.extend(nums[left:mid+1])
            temp.extend(nums[right:high+1])
            
            nums[low:high+1] = temp
        
        def reverse_pairs(low, mid, high):
            right = mid + 1
            cnt = 0
            for i in range(low, mid + 1):
                while right <= high and nums[i] > 2 * nums[right]:
                    right += 1
                cnt += (right - (mid + 1))
            return cnt
        
        return mergeSort(0, len(nums) - 1)

if __name__ == "__main__":
    sol = Solution()
    print(sol.reversePairs([1,3,2,3,1]))  # 2
    print(sol.reversePairs([2,4,3]))      # 0

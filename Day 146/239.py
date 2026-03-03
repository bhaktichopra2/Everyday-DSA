# 239. Sliding Window Maximum

# You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

# Return the max sliding window.

from collections import deque

class Solution:
    def maxSlidingWindow(self, nums, k):
        dq = deque()
        res = []

        for i in range(len(nums)):

            # Remove indices outside window
            if dq and dq[0] <= i - k:
                dq.popleft()

            # Remove smaller elements from back
            while dq and nums[dq[-1]] <= nums[i]:
                dq.pop()

            dq.append(i)

            # Start adding results once window is formed
            if i >= k - 1:
                res.append(nums[dq[0]])

        return res
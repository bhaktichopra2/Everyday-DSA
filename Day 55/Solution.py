# 347. Top K Frequent Elements
# Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
from typing import List
from collections import Counter
import heapq

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)
        heap = []
        for num, freq in count.items():
            if len(heap) < k:
                heapq.heappush(heap, (freq, num))  # min-heap by freq
            elif freq > heap[0][0]:
                heapq.heapreplace(heap, (freq, num))
        top_k = [num for freq, num in heap]
        return top_k

if __name__ == "__main__":
    s = Solution()
    print(s.topKFrequent([1,1,1,2,2,3], 2))  # Example test

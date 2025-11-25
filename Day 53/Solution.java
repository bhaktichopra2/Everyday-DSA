// 215. Kth Largest Element in an Array
// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Can you solve it without sorting?
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap of size k
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll(); // remove smallest
            }
        }
        // Top of the heap is kth largest
        return pq.peek();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findKthLargest(new int[]{3,2,1,5,6,4}, 2));         // 5
        System.out.println(s.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));   // 4
    }
}

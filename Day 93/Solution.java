// 169. Majority Element
// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
import java.util.*;

public class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> counts = new HashMap<>();

        for(int num : nums){
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()){
            if(entry.getValue() > n/2){
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.majorityElement(new int[]{3,2,3}));           // 3
        System.out.println(sol.majorityElement(new int[]{2,2,1,1,1,2,2}));  // 2
    }
}

// 229. Majority Element II
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
import java.util.*;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int threshold = n/3 + 1;

        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) == threshold) {
                result.add(nums[i]);
            }
            if(result.size() == 2) break;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.majorityElement(new int[]{3,2,3}));                    // [3]
        System.out.println(sol.majorityElement(new int[]{3,1,2,3,2}));               // [3,2]
        System.out.println(sol.majorityElement(new int[]{1,1,1,2,3,4}));             // [1]
    }
}

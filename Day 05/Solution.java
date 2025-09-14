/*
 * 1200. Minimum Absolute Difference
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr
*/
// First Approach

// class Solution {
//     public List<List<Integer>> minimumAbsDifference(int[] arr) {
//         Arrays.sort(arr);

//         List<List<Integer>> res = new ArrayList<>();
//         int minDiff = Integer.MAX_VALUE;

//         for(int i=0; i<arr.length-1; i++){
//             int currentDiff = arr[i+1]-arr[i];
//             if(currentDiff < minDiff){
//                 minDiff = currentDiff;
//                 res.clear();
//                 res.add(Arrays.asList(arr[i],arr[i+1]));
//             }else if(currentDiff == minDiff){
//                 res.add(Arrays.asList(arr[i],arr[i+1]));
//             }
//         }
//         return res;
//     }
// }

//Through Sliding Window
import java.util.*;

public class Solution{
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (minDiff == arr[i + 1] - arr[i]) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minimumAbsDifference(new int[]{4,2,1,3})); // [[1, 2], [2, 3], [3, 4]]
        System.out.println(sol.minimumAbsDifference(new int[]{1,3,6,10,15})); // [[1, 3]]
        System.out.println(sol.minimumAbsDifference(new int[]{3,8,-10,23,19,-4,-14,27})); // [[-14, -10], [19, 23], [23, 27]]
    }
}

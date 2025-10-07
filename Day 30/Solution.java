// 1550. Three Consecutive Odds
// Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                num++;
                if (num == 3) {
                    return true;
                }
            } else {
                num = 0;
            }
        }
        return false;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testArr = {2, 6, 4, 1, 3, 5};
        System.out.println(solution.threeConsecutiveOdds(testArr)); // Expected: true
    }
}

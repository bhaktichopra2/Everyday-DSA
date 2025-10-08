// 1822. Sign of the Product of an Array
// Implement a function signFunc(x) that returns:

// 1 if x is positive.
// -1 if x is negative.
// 0 if x is equal to 0.
// You are given an integer array nums. Let product be the product of all values in the array nums.

// Return signFunc(product).

public class Solution{
    public int arraySign(int[] nums) {
        int product = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                product = -product;
            }
        }
        return product;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testNums = {-1, -2, -3, 4, 3, 2, 1};
        System.out.println(solution.arraySign(testNums)); // Expected: -1
    }
}

// 1822. Sign of the Product of an Array
// Implement a function signFunc(x) that returns:

// 1 if x is positive.
// -1 if x is negative.
// 0 if x is equal to 0.
// You are given an integer array nums. Let product be the product of all values in the array nums.

// Return signFunc(product).
public int arraySign(int[] nums) {
    int negativeCount = 0;
    for (int num : nums) {
        if (num == 0) return 0;
        if (num < 0) negativeCount++;
    }
    return (negativeCount % 2 == 0) ? 1 : -1;
}

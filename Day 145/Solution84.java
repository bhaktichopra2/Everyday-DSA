// 84. Largest Rectangle in Histogram

// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

import java.util.Stack;

public class Solution84 {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Iterate one extra step to empty the stack
        for (int i = 0; i <= n; i++) {

            // While current bar is smaller than the bar at stack top
            while (!stack.isEmpty() &&
                   (i == n || heights[stack.peek()] >= (i < n ? heights[i] : 0))) {

                int height = heights[stack.pop()];

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    // ---- Test main for VS Code ----
    public static void main(String[] args) {
        Solution84 sol = new Solution84();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(sol.largestRectangleArea(heights)); // Output: 10
    }
}
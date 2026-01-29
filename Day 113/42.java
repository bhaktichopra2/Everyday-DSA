// 42. Trapping Rain Water
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int maxL = 0, maxR = 0;
        int total = 0;

        while(l <= r){
            if(height[l] <= height[r]){
                if(height[l] > maxL){
                    maxL = height[l];
                } else {
                    total += maxL - height[l];
                }
                l++;
            } else {
                if(height[r] > maxR){
                    maxR = height[r];
                } else {
                    total += maxR - height[r];
                }
                r--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,2,0,3,2,5};
        
        System.out.println("Test 1: " + sol.trap(height1));  // 6
        System.out.println("Test 2: " + sol.trap(height2));  // 9
    }
}

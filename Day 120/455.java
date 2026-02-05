// 455. Assign Cookies
// Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

// Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort both greedily: kids' hunger & cookies' size
        Arrays.sort(g);  // g = kids' hunger levels
        Arrays.sort(s);  // s = cookie sizes
        
        int kid = 0;     // Current kid index
        int cookie = 0;  // Current cookie index
        
        // Two pointers: match cookies to kids
        while (kid < g.length && cookie < s.length) {
            // Cookie big enough? Give to kid & move to next kid
            if (s[cookie] >= g[kid]) {
                kid++;
            }
            // Always move to next cookie (greedy)
            cookie++;
        }
        
        return kid;  // Number of satisfied kids
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test case: kids=[1,2,3], cookies=[1,1]
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println("Happy kids: " + sol.findContentChildren(g, s));
        // Output: 1 (only 1 kid gets cookie)
    }
}

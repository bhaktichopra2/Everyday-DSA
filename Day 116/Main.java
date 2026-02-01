// Minimum number of platforms required for a railway
// Problem Statement: We are given two arrays that represent the arrival and departure times of trains that stop at the platform. We need to find the minimum number of platforms needed at the railway station so that no train has to wait.

import java.util.Arrays;

class Solution {
    // Function to find minimum platforms required
    public int countPlatforms(int n, int[] arr, int[] dep) {
        // Sort both arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // Initialize counters and pointers
        int platforms = 1;
        int result = 1;
        int i = 1, j = 0;

        // Traverse both arrays
        while (i < n && j < n) {
            // If next train arrives before current one departs
            if (arr[i] <= dep[j]) {
                // One more platform needed
                platforms++;
                i++;
            } else {
                // One train departs, platform freed
                platforms--;
                j++;
            }

            // Update maximum required platforms
            result = Math.max(result, platforms);
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        int n = arr.length;

        Solution obj = new Solution();
        System.out.println("Minimum number of Platforms required " +
            obj.countPlatforms(n, arr, dep));
    }
}

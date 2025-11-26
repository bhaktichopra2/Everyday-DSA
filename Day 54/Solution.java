// 973. K Closest Points to Origin
// Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

// The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

// You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
import java.util.*;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // max-heap by distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                b[0]*b[0] + b[1]*b[1],
                a[0]*a[0] + a[1]*a[1]
            )
        );

        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll(); // remove farthest
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            res[i][0] = p[0];
            res[i][1] = p[1];
            i++;
        }
        return res;
    }

    // VSCode test
    public static void main(String[] args) {
        int[][] points = { {1, 3}, {-2, 2}, {5, 8}, {0, 1} };
        int k = 2;
        Solution s = new Solution();
        int[][] ans = s.kClosest(points, k);
        for (int[] p : ans) {
            System.out.println(p[0] + " " + p[1]);
        }
    }
}

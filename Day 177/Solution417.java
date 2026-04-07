// 417. Pacific Atlantic Water Flow

// There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

// The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

// The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

// Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

import java.util.*;
import java.util.List;

public class Solution417 {

    private int ROWS, COLS;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        // Pacific: top row
        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pacific, heights[0][c]);
            dfs(ROWS - 1, c, atlantic, heights[ROWS - 1][c]);
        }

        // Pacific: left column
        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pacific, heights[r][0]);
            dfs(r, COLS - 1, atlantic, heights[r][COLS - 1]);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, int prevHeight) {
        if (
            r < 0 || c < 0 || r >= ROWS || c >= COLS ||
            visited[r][c] ||
            heights[r][c] < prevHeight
        ) {
            return;
        }

        visited[r][c] = true;

        dfs(r + 1, c, visited, heights[r][c]);
        dfs(r - 1, c, visited, heights[r][c]);
        dfs(r, c + 1, visited, heights[r][c]);
        dfs(r, c - 1, visited, heights[r][c]);
    }

    public static void main(String[] args) {
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };

        Solution417 sol = new Solution417();
        System.out.println(sol.pacificAtlantic(heights));
    }
}
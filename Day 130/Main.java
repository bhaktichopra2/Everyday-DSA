// Rat in a Maze
// Problem Statement: Given a grid of dimensions n x n. A rat is placed at coordinates (0, 0) and wants to reach at coordinates (n-1, n-1). Find all possible paths that rat can take to travel from (0, 0) to (n-1, n-1). The directions in which rat can move are 'U' (up) , 'D' (down) , 'L' (left) , 'R' (right).
// The value 0 in grid denotes that the cell is blocked and rat cannot use that cell for travelling, whereas value 1 represents that rat can travel through the cell. If the cell (0, 0) has 0 value, then mouse cannot move to any other cell.

import java.util.*;

// Class to solve the Rat in a Maze problem
class Solution {

    // Function to check if the cell is within maze and valid to move
    boolean isSafe(int x, int y, int n, int[][] maze, int[][] visited) {
        return (x >= 0 && x<n && y>=0 && y<n && maze[x][y] == 1 && visited[x][y] == 0);
    }

    // Function to solve maze using backtracking
    void solve(int i, int j, int n, int[][] maze, int[][] visited, String path, List<String> res) {
        if(i == n-1 && j == n-1){
            res.add(path);
            return;
        }

        visited[i][j] = 1;

        //Down
        if(isSafe(i+1, j, n, maze, visited)){
            solve(i+1, j, n, maze, visited, path +"D", res);
        }
        //Left
        if(isSafe(i, j-1, n, maze, visited)){
            solve(i, j-1, n, maze, visited, path +"L", res);
        }
        //Right
        if(isSafe(i, j+1, n, maze, visited)){
            solve(i, j+1, n, maze, visited, path +"R", res);
        }
        //Up
        if(isSafe(i-1, j, n, maze, visited)){
            solve(i-1, j, n, maze, visited, path +"U", res);
        }

        visited[i][j] = 0;
    }

    // Main function to find all paths
    List<String> findPath(int[][] maze, int n) {
        List<String> res = new ArrayList<>();
        int[][] visited = new int[n][n];
        if(maze[0][0] == 1){
            solve(0, 0, n, maze, visited, "",res);
        }
        return res;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };
        int n = maze.length;
        Solution obj = new Solution();
        List<String> paths = obj.findPath(maze, n);

        for (String p : paths) {
            System.out.print(p + " ");
        }
    }
}

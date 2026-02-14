// M - Coloring Problem
// Problem Statement: Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that no two adjacent vertices of the graph are colored with the same color.
import java.util.*;

class Solution {
    public static boolean graphColoring(boolean[][] graph, int m, int N) {
        int[] color = new int[N];
        Arrays.fill(color, 0);
        if(solve(0, m, N, color, graph)) return true;
        return false;
    }

    public static boolean solve(int node, int m, int N, int[]color, boolean[][]graph){
        if(node == N){
            return true;
        }
        for(int i=0; i<m; i++){
            if(isSafe(node, m, N, color, graph)){
                color[node] = i;
                if(solve(node + 1, m, N, color, graph)) return true;
                color[node] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int node,int col, int N, int[] color, boolean[][] graph){
        for(int k=0; k<N; k++){
            if(k != node && graph[k][node] && color[k] == col){
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        int N = 4;  // Number of nodes
        int m = 3;  // Maximum number of colors

        // Create a sample graph with edges (0,1), (1,2), (2,3), (3,0), (0,2)
        boolean[][] graph = new boolean[101][101];
        graph[0][1] = graph[1][0] = true;
        graph[1][2] = graph[2][1] = true;
        graph[2][3] = graph[3][2] = true;
        graph[3][0] = graph[0][3] = true;
        graph[0][2] = graph[2][0] = true;

        // Output if the graph can be colored with at most m colors
        System.out.println(Solution.graphColoring(graph, m, N));
    }
}
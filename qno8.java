// The Traveling Salesman Problem (TSP) is a classic problem in combinatorial optimization, 
// where the task is to find the shortest possible route that visits every city exactly once 
// and returns to the original city. It is an NP-hard problem, meaning that there is no known 
// polynomial-time algorithm that solves it optimally for all instances. However, dynamic 
// programming can be used to efficiently solve small to medium-sized instances of the problem.

// Dynamic programming (DP) is a technique where the problem is divided into overlapping subproblems, 
// and solutions to these subproblems are stored and reused to solve larger subproblems. For TSP, 
// dynamic programming is used to efficiently compute the shortest tour that visits all cities.
import java.util.Arrays;

public class qno8 {

    public static int tsp(int[][] graph) {
        int n = graph.length; // Number of cities

        int[][] dp = new int[1 << n][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[1][0] = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int last = 0; last < n; last++) {
                if ((mask & (1 << last)) != 0) {
                    for (int j = 0; j < n; j++) {
                        if (j != last && (mask & (1 << j)) != 0) {
                            dp[mask][last] = Math.min(dp[mask][last], dp[mask ^ (1 << last)][j] + graph[j][last]);
                        }
                    }
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int last = 1; last < n; last++) {
            minCost = Math.min(minCost, dp[(1 << n) - 1][last] + graph[last][0]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 10, 15, 20 },
                          { 10, 0, 35, 25 },
                          { 15, 35, 0, 30 },
                          { 20, 25, 30, 0 } };
        
        int minCost = tsp(graph);
        System.out.println("Minimum cost for TSP: " + minCost);
    }
}

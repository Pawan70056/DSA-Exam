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

        // dp[mask][i] represents the minimum cost to visit all cities in mask and ending at city i
        int[][] dp = new int[1 << n][n];

        // Initialize dp table with maximum values
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Base case: starting from city 0
        dp[1][0] = 0;

        // Iterate through all possible subsets of cities
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int last = 0; last < n; last++) {
                // Check if last city is in the subset represented by mask
                if ((mask & (1 << last)) != 0) {
                    // Try to reach last city from any other city j
                    for (int j = 0; j < n; j++) {
                        // Check if city j is not the same as last city and is in the subset represented by mask
                        if (j != last && (mask & (1 << j)) != 0) {
                            // Update the minimum cost to reach last city from city j
                            dp[mask][last] = Math.min(dp[mask][last], dp[mask ^ (1 << last)][j] + graph[j][last]);
                        }
                    }
                }
            }
        }

        // Find the minimum cost to return to city 0 from any other city
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

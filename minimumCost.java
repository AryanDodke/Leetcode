import java.util.*;

class Solution {
    public int minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26; // Number of lowercase English letters
        int INF = Integer.MAX_VALUE / 2;
        
        // Initialize distance array with high values
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        // Set up direct transformations
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }
        
        // Floyd-Warshall algorithm to find shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        // Calculate the total minimum cost
        int totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            char srcChar = source.charAt(i);
            char tgtChar = target.charAt(i);
            if (srcChar == tgtChar) continue;
            
            int from = srcChar - 'a';
            int to = tgtChar - 'a';
            
            if (dist[from][to] == INF) {
                return -1; // Impossible to convert
            }
            
            totalCost += dist[from][to];
        }
        
        return totalCost;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String source1 = "abcd";
        String target1 = "acbe";
        char[] original1 = {'a','b','c','c','e','d'};
        char[] changed1 = {'b','c','b','e','b','e'};
        int[] cost1 = {2,5,5,1,2,20};
        System.out.println(solution.minimumCost(source1, target1, original1, changed1, cost1)); // Output: 28

        String source2 = "aaaa";
        String target2 = "bbbb";
        char[] original2 = {'a','c'};
        char[] changed2 = {'c','b'};
        int[] cost2 = {1,2};
        System.out.println(solution.minimumCost(source2, target2, original2, changed2, cost2)); // Output: 12

        String source3 = "abcd";
        String target3 = "abce";
        char[] original3 = {'a'};
        char[] changed3 = {'e'};
        int[] cost3 = {10000};
        System.out.println(solution.minimumCost(source3, target3, original3, changed3, cost3)); // Output: -1
    }
}

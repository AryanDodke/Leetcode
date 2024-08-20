class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        
        // Compute the suffix sum array
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }
        
        // DP array
        int[][] dp = new int[n][n + 1]; // dp[i][m] represents the max stones Alice can get from i-th pile with M = m
        
        // Fill the DP array
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                // If we are at the last piles, take all stones
                if (i + 2 * m >= n) {
                    dp[i][m] = suffixSum[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        dp[i][m] = Math.max(dp[i][m], suffixSum[i] - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }
        
        // The result is dp[0][1] which is the max stones Alice can get starting with M = 1
        return dp[0][1];
    }
}

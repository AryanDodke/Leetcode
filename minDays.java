class Solution {

    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Step 1: If already disconnected
        if (countIslands(grid) != 1) return 0;
        
        // Step 2: Try to disconnect by removing one cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;  // temporarily remove the land
                    if (countIslands(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;  // restore the land
                }
            }
        }
        
        // Step 3: Otherwise, it takes at least two days
        return 2;
    }
    
    private int countIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    if (count > 1) return count;  // More than one island
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || visited[i][j]) return;
        
        visited[i][j] = true;
        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
    }
}

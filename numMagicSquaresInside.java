class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        // Check if the numbers are from 1 to 9
        boolean[] seen = new boolean[10];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        // Check rows, columns and diagonals sums
        int sum1 = grid[row][col] + grid[row][col+1] + grid[row][col+2]; // first row sum

        for (int i = 0; i < 3; i++) {
            int rowSum = grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2];
            int colSum = grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i];
            if (rowSum != sum1 || colSum != sum1) {
                return false;
            }
        }

        // Check diagonals
        int diag1 = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
        int diag2 = grid[row][col+2] + grid[row+1][col+1] + grid[row+2][col];
        
        return diag1 == sum1 && diag2 == sum1;
    }
}


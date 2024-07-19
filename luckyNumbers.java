import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] minInRows = new int[m];
        int[] maxInCols = new int[n];

        // Initialize minInRows with maximum integer value
        Arrays.fill(minInRows, Integer.MAX_VALUE);

        // Initialize maxInCols with minimum integer value
        Arrays.fill(maxInCols, Integer.MIN_VALUE);

        // Find the minimum element in each row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < minInRows[i]) {
                    minInRows[i] = matrix[i][j];
                }
            }
        }

        // Find the maximum element in each column
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] > maxInCols[j]) {
                    maxInCols[j] = matrix[i][j];
                }
            }
        }

        // Collect all lucky numbers
        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minInRows[i] && matrix[i][j] == maxInCols[j]) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }

        return luckyNumbers;
    }
}

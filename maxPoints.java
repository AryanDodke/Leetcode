class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] prevRow = new long[n];

        // Initialize the first row
        for (int c = 0; c < n; c++) {
            prevRow[c] = points[0][c];
        }

        // Iterate over each row starting from the second row
        for (int r = 1; r < m; r++) {
            long[] currRow = new long[n];

            // Left-to-right pass
            long leftMax = prevRow[0];
            for (int c = 0; c < n; c++) {
                leftMax = Math.max(leftMax, prevRow[c] + c);
                currRow[c] = Math.max(currRow[c], points[r][c] + leftMax - c);
            }

            // Right-to-left pass
            long rightMax = prevRow[n-1] - (n-1);
            for (int c = n - 1; c >= 0; c--) {
                rightMax = Math.max(rightMax, prevRow[c] - c);
                currRow[c] = Math.max(currRow[c], points[r][c] + rightMax + c);
            }

            // Move to the next row
            prevRow = currRow;
        }

        // The maximum points that can be achieved is the max value in the last row
        long maxPoints = 0;
        for (long pointsInLastRow : prevRow) {
            maxPoints = Math.max(maxPoints, pointsInLastRow);
        }

        return maxPoints;
    }
}

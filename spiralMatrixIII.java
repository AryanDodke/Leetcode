
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int dir = 0; // Start by moving east
        int steps = 1; // Initial number of steps in a direction
        int totalCells = rows * cols;
        int[][] result = new int[totalCells][2];
        int count = 0;

        int r = rStart, c = cStart;
        result[count++] = new int[] { r, c };

        while (count < totalCells) {
            for (int i = 0; i < 2; i++) { // There are two turns for each layer
                for (int j = 0; j < steps; j++) {
                    r += directions[dir][0];
                    c += directions[dir][1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[count++] = new int[] { r, c };
                    }
                }
                dir = (dir + 1) % 4; // Change direction
            }
            steps++; // Increase the number of steps for the next layer
        }

        return result;
    }
}

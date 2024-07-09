 class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        int[] time = new int[n];
        int[] wait = new int[n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            t = Math.max(t, customers[i][0]) + customers[i][1];
            time[i] = t;
            wait[i] = time[i] - customers[i][0];
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += wait[i];
        }
        return sum / n;
    }
}

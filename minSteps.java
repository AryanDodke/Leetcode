class Solution {
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {  // If i is a factor of n
                res += i;  // Add the factor to the result (this is the number of operations required)
                n /= i;  // Reduce n by dividing it by i
            }
        }
        return res;
    }
}

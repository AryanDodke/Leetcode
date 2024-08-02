class Solution {
    public int minSwaps(int[] nums) {
        int totalOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                totalOnes++;
            }
        }

        int n = nums.length;

        // Edge case: if there are no 1's or the array is already grouped
        if (totalOnes == 0 || totalOnes == n) {
            return 0;
        }

        // Initialize the first window
        int maxOnesInWindow = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (nums[i] == 1) {
                maxOnesInWindow++;
            }
        }

        int currentOnesInWindow = maxOnesInWindow;

        // Sliding the window
        for (int i = 1; i < n; i++) {
            currentOnesInWindow += nums[(i + totalOnes - 1) % n] - nums[i - 1];
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnesInWindow);
        }

        // Minimum swaps required
        return totalOnes - maxOnesInWindow;
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        // n is not negative & n is power of 2, then n - 1 should be a multiple of n.
        if (n > 0 && (n & (n - 1)) == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
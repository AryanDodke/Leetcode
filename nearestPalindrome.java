import java.util.HashSet;
import java.util.Set;

class Solution {
    public String nearestPalindromic(String n) {
        int length = n.length();
        long num = Long.parseLong(n);
        
        // Edge case for "1"
        if (num == 1) return "0";
        
        // Generate candidates
        Set<Long> candidates = new HashSet<>();
        // First candidate: All 9's with length n-1, e.g., "999" -> "99"
        candidates.add((long) Math.pow(10, length - 1) - 1);
        // Second candidate: All 0's with 1 in start and end, e.g., "100" -> "101"
        candidates.add((long) Math.pow(10, length) + 1);
        
        // Palindrome based on prefix and its neighbors
        long prefix = Long.parseLong(n.substring(0, (length + 1) / 2));
        for (long i = -1; i <= 1; i++) {
            String prefixStr = String.valueOf(prefix + i);
            String candidate;
            if (length % 2 == 0) {
                candidate = prefixStr + new StringBuilder(prefixStr).reverse().toString();
            } else {
                candidate = prefixStr + new StringBuilder(prefixStr.substring(0, prefixStr.length() - 1)).reverse().toString();
            }
            candidates.add(Long.parseLong(candidate));
        }
        
        // Remove the original number from candidates
        candidates.remove(num);
        
        // Find the closest palindrome
        long closest = -1;
        for (long candidate : candidates) {
            if (closest == -1 || Math.abs(candidate - num) < Math.abs(closest - num) ||
                    (Math.abs(candidate - num) == Math.abs(closest - num) && candidate < closest)) {
                closest = candidate;
            }
        }
        
        return String.valueOf(closest);
    }
}

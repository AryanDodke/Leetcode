import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Count the frequency of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Create a list from the elements of the array
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        // Sort the list based on frequency and value
        Collections.sort(list, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            if (freqA == freqB) {
                return b - a; // Sort by value in descending order
            } else {
                return freqA - freqB; // Sort by frequency in ascending order
            }
        });
        
        // Convert the sorted list back to an array
        int[] result = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2, 2, 2, 3};
        int[] sorted = solution.frequencySort(nums);
        System.out.println(Arrays.toString(sorted)); // Output: [3, 1, 1, 2, 2, 2]
    }
}

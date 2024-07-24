import java.util.*;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Define a comparator to compare based on the mapped values
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                long mappedA = getMappedValue(a, mapping);
                long mappedB = getMappedValue(b, mapping);
                return Long.compare(mappedA, mappedB);
            }
        };
        
        // Convert nums array to a list of Integer to use custom comparator
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        
        // Sort the list using the custom comparator
        numsList.sort(comparator);
        
        // Convert the sorted list back to an array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsList.get(i);
        }
        
        return nums;
    }
    
    private long getMappedValue(int num, int[] mapping) {
        StringBuilder mappedValue = new StringBuilder();
        String numStr = String.valueOf(num);
        
        for (char c : numStr.toCharArray()) {
            int digit = c - '0';
            mappedValue.append(mapping[digit]);
        }
        
        return Long.parseLong(mappedValue.toString());
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] mapping1 = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums1 = {991, 338, 38};
        System.out.println(Arrays.toString(solution.sortJumbled(mapping1, nums1))); // Output: [338, 38, 991]

        int[] mapping2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums2 = {789, 456, 123};
        System.out.println(Arrays.toString(solution.sortJumbled(mapping2, nums2))); // Output: [123, 456, 789]
    }
}

class Solution {
    public void merge(int nums[], int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = nums[start + i];
        }

        for (int i = 0; i < n2; i++) {
            arr2[i] = nums[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = start;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                nums[k] = arr1[i];
                i++;
            } else {
                nums[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = arr1[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = arr2[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int nums[], int start, int end) {
        if (start < end) { // Correct base condition
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}
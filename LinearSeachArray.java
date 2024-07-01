public class LinearSeachArray {

    static int LSearch(int arr[], int target){
        if (arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (element == target) {
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        int target = 20;
        int ans = LSearch(nums, target);
        System.out.println(ans);
    }
}

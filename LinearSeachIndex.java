public class LinearSeachIndex {


    static int LSearch(int arr[], int target, int start, int end){
        if (arr.length == 0) {
            return -2;
        }

        for( int i = start; i <=end ; i++){
            int element = arr[i];
            if (element == target){
                return i;
            }
        }
        return -3;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        int target = 3;
        System.out.println(LSearch(arr, target, 1, 5));
    }
}

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for( int number : nums){
            if (IsEven(number)) {
                count++;     
            }
        }
        return count;
    }

    boolean IsEven(int number){
        int even = Digits(number);
        if (even %2 == 0) {
            return true;   
        }
        return false;
    }

    int Digits(int num){
        int count = 0;
       
        while ( num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
    
}
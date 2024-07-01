class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int countShifts = 0;
        while(left < right){
            left >>=1;
            right >>=1;
            countShifts++;
        }
        return left << countShifts;
    }
}
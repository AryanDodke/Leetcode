public class Palindrome {
    public boolean palindrome(int x){
        if ( x < 0) {
            return false;
        }
        int original = x;
        int reverse = 0;
        while(x != 0){
            int lastDigit = x % 10;
            reverse = reverse * 10 + lastDigit;
            x = x / 10;
        }
        return original == reverse;
    }
}

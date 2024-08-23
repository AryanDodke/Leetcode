class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0, denominator = 1;
        int i = 0, n = expression.length();
        
        while (i < n) {
            // Parse the numerator
            int sign = 1;
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }
            
            int num = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + (expression.charAt(i++) - '0');
            }
            num = num * sign;
            
            // Skip the '/'
            i++;
            
            // Parse the denominator
            int denom = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                denom = denom * 10 + (expression.charAt(i++) - '0');
            }
            
            // Calculate the new numerator and denominator
            numerator = numerator * denom + num * denominator;
            denominator *= denom;
            
            // Simplify the fraction
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return numerator + "/" + denominator;
    }
    
    // Helper function to compute the GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

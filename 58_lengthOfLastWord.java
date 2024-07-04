import java.util.*;

class Solution {
    public int lengthOfLastWord(String s) {
        s = new StringBuilder(s).reverse().toString().trim();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                break;
            }
        }
        return length;
    }
}

class Solution2 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int length = s.lastIndexOf(' ');
        return s.length() - length - 1;
    }
}


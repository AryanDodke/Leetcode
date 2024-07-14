import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return calculatePoints(s, 'a', 'b', x) + calculatePoints(rebuildString(s, 'a', 'b'), 'b', 'a', y);
        } else {
            return calculatePoints(s, 'b', 'a', y) + calculatePoints(rebuildString(s, 'b', 'a'), 'a', 'b', x);
        }
    }

    private int calculatePoints(String s, char first, char second, int points) {
        Stack<Character> stack = new Stack<>();
        int totalPoints = 0;
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop();  // remove the previous character as part of the pair
                totalPoints += points;  // add the points for this removal
            } else {
                stack.push(c);  // push current character to the stack
            }
        }
        
        return totalPoints;
    }

    private String rebuildString(String s, char first, char second) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop();  // remove the previous character as part of the pair
            } else {
                stack.push(c);  // push current character to the stack
            }
        }
        
        StringBuilder remaining = new StringBuilder();
        while (!stack.isEmpty()) {
            remaining.insert(0, stack.pop());
        }
        
        return remaining.toString();
    }
}

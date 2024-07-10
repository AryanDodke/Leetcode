import java.util.Stack;

class Solution {
    @SuppressWarnings("unchecked")
    public int minOperations(String[] logs) {
        @SuppressWarnings("rawtypes")
        Stack element = new Stack<>();
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")) {
                if (element.size() > 0)
                    element.pop();
            } else if (!logs[i].equals("./")) {
                element.push(logs[i]);
            }
        }
        return element.size();
    }
}
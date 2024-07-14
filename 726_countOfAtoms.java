import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        int n = formula.length();
        for (int i = 0; i < n;) {
            char c = formula.charAt(i);

            if (c == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (c == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                int iStart = i;
                int count = 1;  // Default count is 1 if no number follows ')'
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (i > iStart) {
                    count = Integer.parseInt(formula.substring(iStart, i));
                }
                for (String key : top.keySet()) {
                    int v = top.get(key);
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + v * count);
                }
            } else {
                int iStart = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + count);
            }
        }

        Map<String, Integer> finalCount = stack.pop();
        List<String> keys = new ArrayList<>(finalCount.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key);
            int count = finalCount.get(key);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countOfAtoms("H2O")); // Output: "H2O"
        System.out.println(solution.countOfAtoms("Mg(OH)2")); // Output: "H2MgO2"
        System.out.println(solution.countOfAtoms("K4(ON(SO3)2)2")); // Output: "K4N2O14S4"
    }
}

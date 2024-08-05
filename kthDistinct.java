import java.util.*;
import java.util.Map.Entry;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        String result = "";

        @SuppressWarnings({ "unchecked", "rawtypes" })
        Map<String, Integer> map = new LinkedHashMap();

        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int current = 1;

        for (Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1 && current == k) {
                result = e.getKey();
                break;
            } else if (e.getValue() == 1) {
                current++;
            }
        }
        return result;
    }
}
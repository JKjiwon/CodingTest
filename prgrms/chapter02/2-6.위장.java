import java.util.HashMap;
import java.util.Map;

/**
 * 경우의 수, Map
 */

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> items = new HashMap<>();

        for (String[] cloth : clothes) {
            items.put(cloth[1], items.getOrDefault(cloth[1], 0) + 1);
        }

        int answer = 1;

        for (String item : items.keySet()) {
            answer *= (items.get(item) + 1);
        }
        
        return answer - 1;
    }
}
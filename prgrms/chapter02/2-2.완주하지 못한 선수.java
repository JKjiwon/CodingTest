import java.util.HashMap;
import java.util.Map;

/**
 * HashMap을 이용한 풀이.
 * personInTrack.getOrDefault(key, defaultValue) 이용
 */

class Solution {
    public String solution(String[] participants, String[] completions) {

        String answer = "";

        Map<String, Integer> personInTrack = new HashMap<>();

        for (String participant : participants) {
            personInTrack.put(participant, personInTrack.getOrDefault(participant, 0) + 1);
        }

        for (String completion : completions) {
            personInTrack.put(completion, personInTrack.getOrDefault(completion, 0) - 1);
        }

        for (String person : personInTrack.keySet()) {
            if (personInTrack.get(person) > 0) {
                answer = person;
                break;
            }
        }
        return answer;
    }
}
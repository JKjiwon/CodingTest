import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int finishedIndex = 0;
        boolean[] finished = new boolean[progresses.length];
        while (true) {
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            int count = 0;
            while (finishedIndex < progresses.length && progresses[finishedIndex] >= 100) {
                finished[finishedIndex] = true;
                count++;
                finishedIndex++;
            }
            if (count != 0) {
                answer.add(count);
            }

            if (finished[progresses.length - 1])
                break;
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
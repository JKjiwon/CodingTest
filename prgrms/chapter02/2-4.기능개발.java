import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 일이 몇일 남았나? 를 계산해야 한다.
 * Queue : Queue<Integer> leftDate = new LinkedList<>();
 * offer() , poll() , isEmpty()
 * 
 * 중요 : 정수 / 정수 = 정수가 아닌 유리수 => 정수 / (double) 정수 => 즉 캐스팅이 필요하다.
 * ex) Math.ceil(70/30) = 2.0
 *     Math.ceil(70/(float)30) = 3.0
 */

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> leftDate = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int leftProgess = 100 - progresses[i];
            int date = (int) Math.ceil(leftProgess / (double) speeds[i]);
            leftDate.offer(date);
        }

        while (!leftDate.isEmpty()) {
            int left = leftDate.poll();
            int count = 1;
            while (!leftDate.isEmpty() && left >= leftDate.peek()) {
                count++;
                leftDate.poll();
            }
            answer.add(count);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
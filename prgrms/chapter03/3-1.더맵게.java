import java.util.PriorityQueue;

/**
 * int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
 * PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
 * 
 * int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
 * PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
 */

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovilePQ = new PriorityQueue<>();

        for (int sc : scoville) {
            scovilePQ.offer(sc);
        }

        int count = 0;

        while (scovilePQ.size() >= 2) {
            int fisrt = scovilePQ.poll();
            int second = scovilePQ.poll();
            scovilePQ.offer(fisrt + second * 2);
            count += 1;

            if (scovilePQ.peek() >= K)
                break;
        }
        
        if (scovilePQ.peek() < K) {
            return -1;
        }

        return count;
    }
}
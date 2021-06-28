import java.util.LinkedList;
import java.util.Queue;

/**
 *  waitQ 에 트럭이 남아있다면 moveQ 에는 bridgeLength 만큼의 트럭이 존재해야한다.(0도 트럭으러 포함.)
 */

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Integer> waitQ = new LinkedList<>();

        for (int tw : truckWeights) {
            waitQ.offer(tw);
        }

        Queue<Integer> moveQ = new LinkedList<>();
        for (int i = 0; i < bridgeLength; i++) {
            moveQ.offer(0);
        }

        int time = 0;
        int curWeight = 0;

        while (!moveQ.isEmpty()) {
            int moveQOut = moveQ.poll();
            curWeight -= moveQOut;
            time += 1;

            if (!waitQ.isEmpty()) {
                if (curWeight + waitQ.peek() <= weight) {
                    int waitQOut = waitQ.poll();
                    curWeight += waitQOut;
                    moveQ.offer(waitQOut);
                } else {
                    moveQ.offer(0);
                }
            }
        }
        return time;
    }
}
import java.util.Stack;

/**
 * stack : 아직까지 떨어지지 않은 인덱스의 모음
 */

class Solution {
    public int[] solution(int[] prices) {

        Stack<Integer> st = new Stack<>();
        int[] answers = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            while (!st.empty() && prices[i] < prices[st.peek()]) { // i의 수가 이전 보다 감소하는 때.
                answers[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }

        while (!st.empty()) {
            answers[st.peek()] = prices.length - 1 - st.peek();
            st.pop();
        }

        return answers;
    }
}
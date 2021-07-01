import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);

        int answer = 0;
        for (int h = 0; h < len + 1; h++) {
            // 인용 횟수가 h번 보다 크거나 같은 수
            int big = 0;
            // 인용 횟수가 h번 보다 작은 수
            int small = 0;

            for (int j = 0; j < len; j++) {
                if (citations[j] >= h) {
                    big++;
                } else {
                    small++;
                }
            }

            if (big >= h && small <= h) {
                answer = h;
            }
        }
        return answer;
    }
}
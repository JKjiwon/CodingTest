import java.util.Arrays;

/**
 * 배열 자르기 + 정렬
 * 1부터 시작하는 순서를 0부터 시작하는 수로 바꾸기.
 * Arrays.sort() 이용
 */

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int commandLen = commands.length;
        int[] answer = new int[commandLen];

        for (int i = 0; i < commandLen; i++) {
            int from = commands[i][0] - 1;
            int to = commands[i][1] - 1;
            int nTh = commands[i][2] - 1;
            answer[i] = sortedSubArray(array, from, to)[nTh];
        }

        return answer;
    }

    private int[] sortedSubArray(int[] array, int from, int to) {
        int size = to - from + 1;
        int[] result = new int[size];

        for (int i = from; i <= to; i++) {
            result[i - from] = array[i];
        }

        Arrays.sort(result);

        return result;
    }
}
/**
 * 2차원 DP
 * d[i][j] = i, j 도착했을 때 최대값
 * d[i][j] = max(d[i-1][j], d[i-1][j-1]) + t[i][j]; 
 */

class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        int[][] d = new int[N][N];
        d[0][0] = triangle[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = -1;
                if (j - 1 >= 0)
                    temp = d[i - 1][j - 1];
                d[i][j] = Math.max(temp, d[i - 1][j]) + triangle[i][j];
            }
        }

        int answer = -1;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, d[N-1][i]);
        }

        return answer;
    }
}
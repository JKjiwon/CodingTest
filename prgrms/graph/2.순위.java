import java.util.Arrays;

/**
 * 최단 경로 문제 (플로이드 워셜)
 * A -> B 로 도달 할 수 있거나, B->A 로 도달 할 수 있으면 순위를 매길 수 있다.
 */
class Solution {
    private static final int INF = (int) 1e9;

    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != INF || graph[j][i] != INF)
                    count++;
            }
            if (count == n) {
                answer++;
            }
        }
        return answer;
    }
}
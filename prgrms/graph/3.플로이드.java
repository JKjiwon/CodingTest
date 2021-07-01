import java.util.Arrays;
import java.util.Scanner;

/**
 * Boj 30526832
 * 전형적인 플로이드 워셜 문제
 */
public class Main {

    private static final int INF = (int) 1e9;
    private static int n, m;
    private static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = Math.min(graph[a][b], c);
        }

        // 플로이드 워셜 계산
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        // 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] >= INF) {
                    System.out.print("0 ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}


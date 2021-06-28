import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int size, int[][] computers) {

        int count = 0;
        boolean[] visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                dfs(i, computers, size, visited);
                count++;
            }
        }
        
        return count;
    }

    private void bfs(int cur, int[][] computers, int size, boolean[] visited) {
        visited[cur] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(cur);

        while (!q.isEmpty()) {
            cur = q.poll();
            for (int i = 0; i < size; i++) {
                if (!visited[i] && computers[cur][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    private void dfs(int x, int[][] computers, int size, boolean[] visited) {
        visited[x] = true;
        for (int i = 0; i < size; i++) {
            if (x == i)
                continue;
            if (computers[x][i] == 1 && !visited[i]) {
                dfs(i, computers, size, visited);
            }
        }
    }
}
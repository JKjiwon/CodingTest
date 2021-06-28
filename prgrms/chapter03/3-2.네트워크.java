import java.util.*;

class Solution {
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int size = computers.length;
        int count = 0;
        visited = new boolean[size];
        
        for(int i = 0; i < size; i++) {
            if(!visited[i]) {
                bfs(i, computers, size);
                count++;
            }
        }
        return count;
    }
    
    private void bfs(int cur, int[][] computer, int size) {
        visited[cur] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(cur);
        
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int i = 0 ; i < size; i++) {
                if(!visited[i] && computer[cur][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
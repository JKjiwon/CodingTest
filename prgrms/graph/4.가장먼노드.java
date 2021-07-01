import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 최단거리 구하기 - 다익스트라
 */

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

class Solution {
    private static final int INF = (int) 1e9;


    public int solution(int n, int[][] edges) {
        int[] dp = new int[n + 1];
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        Arrays.fill(dp, INF);

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Node(edge[1], 1));
            graph.get(edge[1]).add(new Node(edge[0], 1));
        }

        dijkstra(graph, dp, 1);

        int maxValue = -1;
        for (int i = 1; i <= n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (maxValue == dp[i]) {
                answer++;
            }
        }
        return answer;
    }

    private void dijkstra(ArrayList<ArrayList<Node>> graph, int[] dp, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dp[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curIdx = curNode.getIndex();
            int curDist = curNode.getDistance();

            if (dp[curIdx] < curDist) continue;

            for (int i = 0; i < graph.get(curIdx).size(); i++) {
                Node nextNode = graph.get(curIdx).get(i);
                int cost = dp[curIdx] + nextNode.getDistance();
                if (cost < dp[nextNode.getIndex()]) {
                    dp[nextNode.getIndex()] = cost;
                    pq.offer(new Node(nextNode.getIndex(), cost));
                }
            }
        }
    }
}
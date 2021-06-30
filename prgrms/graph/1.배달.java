import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int distance;

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
    public int compareTo(Node ohter) {
        if (this.getIndex() < ohter.getIndex()) {
            return -1;
        }
        return 1;
    }
}

class Solution {
    private static final int INF = (int) 1e9;

    public int solution(int N, int[][] roads, int K) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, INF);
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(new Node(road[1], road[2]));
            graph.get(road[1]).add(new Node(road[0], road[2]));
        }

        dijkstra(graph, dp, 1);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dp[i] <= K) {
                count++;
            }
        }
        return count;
    }

    private void dijkstra(ArrayList<ArrayList<Node>> graph, int[] dp, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dp[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int nowIdx = curNode.getIndex();
            int dist = curNode.getDistance();

            if (dp[nowIdx] < dist) continue;

            for (int i = 0; i < graph.get(nowIdx).size(); i++) {
                Node nextNode = graph.get(nowIdx).get(i);
                int cost = dp[nowIdx] + nextNode.getDistance();
                if (cost < dp[nextNode.getIndex()]) {
                    dp[nextNode.getIndex()] = cost;
                    pq.offer(new Node(nextNode.getIndex(), cost));
                }
            }
        }
    }
}
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        int[][] visited = new int[row][col];
        bfs(maps, row, col, visited);
        int result = visited[row - 1][col - 1];
        return result > 0 ? result : -1;
    }

    private void bfs(int[][] maps, int row, int col, int[][] visited) {
        Point curPoint = new Point(0, 0);
        visited[0][0] = 1;

        Queue<Point> q = new LinkedList<>();
        q.offer(curPoint);

        while (!q.isEmpty()) {
            curPoint = q.poll();

            for (int i = 0; i < 4; i++) {
                Point nextPoint = curPoint.move(dx[i], dy[i]);

                if (!nextPoint.inRange(row, col) || isWall(nextPoint, maps) || isVisited(nextPoint, visited)) {
                    continue;
                }

                visited[nextPoint.getX()][nextPoint.getY()] = visited[curPoint.getX()][curPoint.getY()] + 1;
                q.offer(nextPoint);
            }
        }
    }

    private boolean isWall(Point point, int[][] maps) {
        return maps[point.getX()][point.getY()] == 0;
    }

    private boolean isVisited(Point point, int[][] visited) {
        return visited[point.getX()][point.getY()] > 0;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Point move(int dx, int dy) {
            return new Point(x + dx, y + dy);
        }

        public boolean inRange(int row, int col) {
            return x >= 0 && x < row && y >= 0 && y < col;
        }
    }
}
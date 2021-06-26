/**
 * hashCode, equals를 조작한 풀이
 * HashSet 은 먼저 hashCode 를 비교 하고 hashCode가 같다면 equals 비교를 통해서 같음을 판단.
 *  
 */
class Solution {
    private final static String DIRECTIONS = "UDRL";
    private final static int MAPSIZE = 5;
    private final static int[] dx = {-1, 1, 0, 0};
    private final static int[] dy = {0, 0, 1, -1};

    public int solution(String dirs) {
        Set<Route> visited = new HashSet<>();
        Point curPoint = new Point(0, 0);

        // 실제 로직
        for (char dir : dirs.toCharArray()) {
            int dirNum = DIRECTIONS.indexOf(dir);
            Point nextPoint = curPoint.getNextPoint(dx[dirNum], dy[dirNum]);
            if (nextPoint != null) {
                visited.add(new Route(curPoint, nextPoint));
                curPoint = nextPoint;
            }
        }
        return visited.size();
    }

    static class Route {
        private Point start;
        private Point end;

        public Route(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        public Point getStart() {
            return start;
        }

        public Point getEnd() {
            return end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Route route = (Route) o;
            return Objects.equals(getStart(), route.getStart()) && Objects.equals(getEnd(), route.getEnd())
                    || Objects.equals(getStart(), route.getEnd()) && Objects.equals(getEnd(), route.getStart());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getStart()) + Objects.hash(getEnd());
        }
    }

    static class Point {
        private int x;
        private int y;

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

        public Point getNextPoint(int dx, int dy) {
            if (x + dx >= -MAPSIZE && x + dx <= MAPSIZE
                    && y + dy >= -MAPSIZE && y + dy <= MAPSIZE) {
                return new Point(x + dx, y + dy);
            }
            return null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return getX() == point.getX() && getY() == point.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    }
}
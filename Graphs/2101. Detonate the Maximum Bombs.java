// https://leetcode.com/problems/detonate-the-maximum-bombs/description/
public int maximumDetonation(int[][] bombs) {
    int n = bombs.length, ans = 0;
    for (int i = 0; i < n; i++) {
        ans = Math.max(ans, dfs(i, new boolean[n], bombs));
    }
    return ans;
}

private int dfs(int idx, boolean[] v, int[][] bombs) {
    int count = 1;
    v[idx] = true;
    int n = bombs.length;
    for (int i = 0; i < n; i++) {
        if (!v[i] && inRange(bombs[idx], bombs[i])) {
            count += dfs(i, v, bombs);
        }
    }
    return count;
}

private boolean inRange(int[] a, int[] b) {
    long dx = a[0] - b[0], dy = a[1] - b[1], r = a[2];
    return dx * dx + dy * dy <= r * r;
}


// Old solution
class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Point, Set<Point>> adjMap = new HashMap<>();        

        for (int i = 0; i < bombs.length; i++) {
            if (!adjMap.containsKey(new Point(bombs[i][0], bombs[i][1], i))) {
                adjMap.put(new Point(bombs[i][0], bombs[i][1], i), new HashSet<>());
            }
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) {
                    continue;
                }
                double squaredDistance = Math.pow(bombs[i][0] - bombs[j][0], 2) + Math.pow(bombs[i][1] - bombs[j][1], 2);         
                if (squaredDistance <= Math.pow(bombs[i][2], 2)) {
                    adjMap.get(new Point(bombs[i][0], bombs[i][1], i)).add(new Point(bombs[j][0], bombs[j][1], j));
                }
            }
        }
        // System.out.println(adjMap);
        int max = 0;
        for (Point point: adjMap.keySet()) {
            Set<Point> visited = new HashSet<>();
            max = Math.max(max, dfs(adjMap, point, visited));
        }
        return max;
    }

    private int dfs(Map<Point, Set<Point>> adjMap, Point point, Set<Point> visited) {
        if (visited.contains(point)) {
            return 0;
        }
        visited.add(point);
        int count = 1;

        if (adjMap.containsKey(point)) {
            for (Point p: adjMap.get(point)) {
                count += dfs(adjMap, p, visited);
            }
        }
        return count;
    }
}
class Point {
    private int x, y, idx;
    public Point(int x, int y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y && this.idx == other.idx;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, idx);
    }

    public String toString() {
        return "Point (x = " + x + ", y = " + y + ")";
    }
}

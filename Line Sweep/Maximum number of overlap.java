// https://www.geeksforgeeks.org/problems/intersecting-intervals/1
class Solution {
    public static int overlap(int n, int[][] intervals) {
        TreeMap<Integer, Integer> line = new TreeMap<>();
        for (int[] interval: intervals) {
            line.put(interval[0], line.getOrDefault(interval[0], 0) + 1);
            line.put(interval[1] + 1, line.getOrDefault(interval[1] + 1, 0) - 1);
        }
        
        int overlap = 0;
        int maxOverlap = 0;
        
        for (int point: line.keySet()) {
            overlap += line.get(point);
            maxOverlap = Math.max(overlap, maxOverlap);
        }
        return maxOverlap;
    }
}
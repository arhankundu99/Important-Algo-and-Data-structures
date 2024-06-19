// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] == point2[1]) {
                    return 0;
                }
                return -1;
            }
        });

        int count = 1;
        int prevEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prevEnd) {
                count++;
                prevEnd = points[i][1];
            }
        }
        return count;
    }
}
// https://leetcode.com/problems/non-overlapping-intervals/description/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int count = 0;
        int prevEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
    //[1, 11], [2, 12], [11, 22], [1, 100]
    //           1         2
}
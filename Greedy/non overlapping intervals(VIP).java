// https://leetcode.com/problems/non-overlapping-intervals/
// similar to n meetings problem

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0)return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[]a, int[] b){
                return a[1] - b[1];
            }
        });
        int count = 1;
        int prev = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= prev){
                prev = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}

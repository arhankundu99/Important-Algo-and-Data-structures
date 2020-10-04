// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3483/
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] == b[0]? b[1] - a[1]: a[0] - b[0];
            }
        });
        int end = intervals[0][1];
        int count = 1;
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][1] <= end)continue;
            end = intervals[i][1];
            count++;
        }
        return count;
    }
}

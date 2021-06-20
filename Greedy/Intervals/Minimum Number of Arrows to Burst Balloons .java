// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3490/
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0)return 0;
        
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1] > b[1])return 1;
                return -1;
            }
        });
        int count = 1;
        
        int prev = points[0][1];
        
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= prev)continue;
            prev = points[i][1];
            count++;
        }
        return count;
    }
}

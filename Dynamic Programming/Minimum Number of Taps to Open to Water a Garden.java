/*
leetcode 1326
There is a one-dimensional garden on the x-axis. 
The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).
There are n + 1 taps located at points [0, 1, ..., n] in the garden.
Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
*/
//O(n) solution similar to vide stiching and jump game 2
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n+1];
        
        for(int i = 0; i < ranges.length; i++){
            int left = Math.max(0, i - ranges[i]);
            int right = i+ranges[i];
            
            arr[left] = Math.max(arr[left], right);
        }
        
        int currEnd = 0, currFarthest = 0, jumps = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(i > currFarthest){
                return -1;
            }
            currFarthest = Math.max(currFarthest, arr[i]);
            
            if(i == currEnd && i != n){
                jumps++;
                currEnd = currFarthest;
            }
        }
        return jumps;
    }
}

// Idea: for every tap, we have a range for that tap. We just have to merge the intervals until we get the interval (0, n)
// Therefore this problem reduces to finding minimum number of merges of intervals to get interval (0,n)
// Time complexity O(n^2)
class Solution {
    int[]dp;
    public int minTaps(int n, int[] ranges) {
        int[][]intervals = new int[n+1][2];
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        for(int i=0;i<=n;i++)
        {
            intervals[i][0] = Math.max(0, i-ranges[i]);
            intervals[i][1] = Math.min(n, i+ranges[i]);
        }
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[]a, int[]b){
                if(a[0]==b[0])return a[1]-b[1];
                return a[0]-b[0];
            }
        });
        int ret = Integer.MAX_VALUE;
        for(int i=0;i<=n;i++)
        {
            if(intervals[i][0]!=0)break;
            int x = dfs(intervals, i+1);
            if(x!=Integer.MAX_VALUE)ret = Math.min(ret,1+x);
        }
        return ret==Integer.MAX_VALUE?-1:ret;
    }
    public int dfs(int[][]intervals, int idx)
    {
        if(intervals[idx][1] == intervals.length-1)return 0;
        if(idx == intervals.length)return Integer.MAX_VALUE;
        
        if(dp[idx]!=-1)return dp[idx];
        
        int ret = Integer.MAX_VALUE;
        
        for(int i=idx;i<intervals.length;i++)
        {
            if(intervals[i][0]>intervals[idx-1][1])break;
            if(intervals[i][1]<=intervals[idx-1][1])continue;
            int x = dfs(intervals, i+1);
            if(x!=Integer.MAX_VALUE)ret = Math.min(ret,1+x);
        }
        dp[idx]=ret;
        return ret;
    }
}

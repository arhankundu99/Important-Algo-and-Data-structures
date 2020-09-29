// https://leetcode.com/contest/weekly-contest-207/problems/maximum-non-negative-product-in-a-matrix/
class Solution {
    int mod = 1000000007;
    public int maxProductPath(int[][] grid) {
        pair[][] dp = new pair[grid.length][grid[0].length];
        
        int r = grid.length;
        int c = grid[0].length;
        
        dp[0][0] = new pair(grid[0][0], grid[0][0]);
        
        for(int i=1;i<r;i++)
            dp[i][0]= new pair(dp[i-1][0].min*grid[i][0],dp[i-1][0].max*grid[i][0]);
       
        for(int j=1;j<c;j++)
            dp[0][j]= new pair(dp[0][j-1].min*grid[0][j],dp[0][j-1].max*grid[0][j]);
        
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                
                long min = Math.min(grid[i][j] * dp[i-1][j].min, grid[i][j] * dp[i][j-1].min);
                min = Math.min(min, Math.min(grid[i][j] * dp[i-1][j].max, grid[i][j] * dp[i][j-1].max));
                
                long max = Math.max(grid[i][j] * dp[i-1][j].min, grid[i][j] * dp[i][j-1].min);
                max = Math.max(max, Math.max(grid[i][j] * dp[i-1][j].max, grid[i][j] * dp[i][j-1].max));
                
                dp[i][j] = new pair(min, max);
                
            }
        }
        
        return Math.max(-1, (int) (dp[grid.length-1][grid[0].length-1].max % mod));
    }
}
class pair{
    long min, max;
    pair(long min, long max){
        this.min = min;
        this.max = max;
    }
}

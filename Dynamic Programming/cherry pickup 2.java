// https://leetcode.com/problems/cherry-pickup-ii/
class Solution {
    int[][][]dp;
    public int cherryPickup(int[][] grid) {
        dp = new int[grid.length][grid[0].length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++)Arrays.fill(dp[i][j], -1);
        }
        
        return solve(grid, 0, 0, grid[0].length-1);
    }
    public int solve(int[][] grid, int r, int c1, int c2){
        if(c1 < 0 || c2 < 0 || c1 == grid[0].length || c2 == grid[0].length)return 0;
        
        if(dp[r][c1][c2] != -1)return dp[r][c1][c2];
        
        int count = 0;
        
        if(c1 == c2)count = grid[r][c1];
        else count = grid[r][c1] + grid[r][c2];
        
        if(r == grid.length-1)return count;
        
        int ans = 0;
        
        ans = Math.max(ans, count + solve(grid, r+1, c1, c2));
        ans = Math.max(ans, count + solve(grid, r+1, c1, c2-1));
        ans = Math.max(ans, count + solve(grid, r+1, c1, c2+1));
        ans = Math.max(ans, count + solve(grid, r+1, c1-1, c2));
        ans = Math.max(ans, count + solve(grid, r+1, c1+1, c2));
        ans = Math.max(ans, count + solve(grid, r+1, c1-1, c2-1));
        ans = Math.max(ans, count + solve(grid, r+1, c1-1, c2+1));
        ans = Math.max(ans, count + solve(grid, r+1, c1+1, c2-1));
        ans = Math.max(ans, count + solve(grid, r+1, c1+1, c2+1));
        
        dp[r][c1][c2] = ans;
        return ans;
    }
}

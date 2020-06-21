// leetcode 174
// Category: Hard
// Problem Link: https://leetcode.com/problems/dungeon-game/
// It is not always possible to find a top down approach to a problem. In that case try bottom up approach
class Solution {
    int[][][]dp;
    public int calculateMinimumHP(int[][] dungeon) {
        dp = new int[dungeon.length][dungeon[0].length][3000];
        
        for(int i = 0; i < dungeon.length; i++)
            for(int j = 0; j < dungeon[0].length; j++)Arrays.fill(dp[i][j], -1);
        
        int ans = helper(0, 0, dungeon, 0);
        return ans == 0? 1: ans;
    }
    public int helper(int r, int c, int[][] dungeon, int currStrength)
    {
        if(r == dungeon.length || c == dungeon[0].length)return Integer.MAX_VALUE;
        
        if(r == dungeon.length - 1 && c == dungeon[0].length - 1)
            return currStrength + dungeon[r][c] > 0? 0: 1-(dungeon[r][c] + currStrength);
        
        if(dp[r][c][currStrength] != -1)return dp[r][c][currStrength];
        
        int strengthNeeded = 0;
        if(currStrength + dungeon[r][c] <= 0)strengthNeeded = 1-(dungeon[r][c] + currStrength);
        
        dp[r][c][currStrength] = strengthNeeded + Math.min(helper(r+1, c, dungeon, currStrength + dungeon[r][c] + strengthNeeded), helper(r, c+1, dungeon, currStrength + dungeon[r][c] + strengthNeeded));
        
        return dp[r][c][currStrength];
    }
    
}

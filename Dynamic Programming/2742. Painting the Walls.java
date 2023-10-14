// https://leetcode.com/problems/painting-the-walls/description/?envType=daily-question&envId=2023-10-14
class Solution {
    private final int MAX_COST = 500 * (int)Math.pow(10, 6);
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i], -1);
        }
        return paintWalls(cost, time, 0, cost.length, dp);
    }

    private int paintWalls(int[] cost, int[] time, int currIdx, int numWallsToBePainted, int[][] dp){
        if(numWallsToBePainted <= 0){
            return 0;
        }

        if(currIdx == cost.length){
            return MAX_COST;
        }

        if(dp[currIdx][numWallsToBePainted] != -1){
            return dp[currIdx][numWallsToBePainted];
        }

        int minCost = cost[currIdx] + paintWalls(cost, time, currIdx + 1, numWallsToBePainted - 1 - time[currIdx], dp);

        minCost = Math.min(minCost, paintWalls(cost, time, currIdx + 1, numWallsToBePainted, dp));

        return dp[currIdx][numWallsToBePainted] = minCost;
    }
}
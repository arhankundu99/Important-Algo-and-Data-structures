leetcode prob number 518
You are given coins of different denominations and a total amount of money. 
Write a function to compute the number of combinations that make up that amount. 
You may assume that you have infinite number of each kind of coin.

class Solution {
    int[][]dp;
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        
        dp = new int[amount+1][coins.length];
        for(int i = 0; i <= amount; i++)Arrays.fill(dp[i], -1);
        return solve(amount, coins, 0);
    }
    public int solve(int amount, int[] coins, int idx)
    {
        if(amount == 0)return 1;
        if(idx == coins.length || coins[idx] > amount)return 0;
        
        if(dp[amount][idx] != -1)return dp[amount][idx];
        dp[amount][idx] = solve(amount-coins[idx], coins, idx)+solve(amount, coins, idx+1);
           
        return dp[amount][idx];
    }
}

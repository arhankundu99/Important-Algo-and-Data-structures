// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

// solution 1 (O(KN^2)) Time limit Exceeded
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k+1];
        for(int i = 0; i < prices.length; i++)Arrays.fill(dp[i], -1);
        return solve(prices, k, 0, dp);
    }
    public int solve(int[] prices, int k, int idx, int[][] dp){
        if(idx >= prices.length-1 || k == 0)return 0;
        
        if(dp[idx][k] != -1)return dp[idx][k];
        
        //we can either buy stock at idx or not buy
        int profit1 = 0;
        
        for(int i = idx+1; i < prices.length; i++){
            if(prices[i] > prices[idx]){
                profit1 = Math.max(profit1, prices[i]-prices[idx]+solve(prices, k-1, i+1, dp));
            }
        }
        int profit2 = solve(prices, k, idx+1, dp);
        dp[idx][k] = Math.max(profit1, profit2);
        
        return dp[idx][k];
    }
}
// O(NK)
class Solution {
    public int maxProfit(int k, int[] prices) {
        
        if(k == 0 || prices.length == 0)return 0;
        
        int ans = 0;
        if(2*k >= prices.length){
            for(int i = 1; i < prices.length; i++){
                ans += Math.max(prices[i]-prices[i-1], 0);
            }
            return ans;
        }
        
        int[][][] dp = new int[prices.length][k+1][2];
        
        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j <= k; j++)Arrays.fill(dp[i][j], -100000000);
        }
        
        //dp[i][j][0] represents the profit till ith index with j transactions and no stock in hand
        //dp[i][j][1] represents the profit till ith index with j transactions and with a stock in hand
        
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        
        for(int i = 1; i < prices.length; i++){
            for(int j = 0; j <= k; j++){
                //if we have stock in hand, we have 2 choices:
                //Either we sell it or not sell it
                dp[i][j][0] = Math.max(prices[i] + dp[i-1][j][1], dp[i-1][j][0]);
                if(j > 0){
                    //if we do not have stock in hand, we have 2 choices:
                    //Either we buy or not buy;
                    dp[i][j][1] = Math.max(dp[i-1][j][1], -prices[i] + dp[i-1][j-1][0]);
                }
            }
        }
        for(int i = 0; i <= k; i++){
            ans = Math.max(ans, dp[prices.length-1][i][0]);
        }
        return ans;
    }
}

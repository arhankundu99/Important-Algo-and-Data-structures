// https://leetcode.com/explore/featured/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3405/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)return 0;
        
        int ans = 0;
        
        int[][] dp = new int[prices.length][2];
        
        for(int i = 0; i < prices.length; i++){
            Arrays.fill(dp[i], -100000000);
        }
        
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        
        for(int i = 1; i < prices.length; i++){
            //if we have stock in hand, we have 2 choices:
            //Either we sell it or not sell it
                
            dp[i][0] = Math.max(prices[i] + dp[i-1][1], dp[i-1][0]);
            if(i < 2)dp[i][1] = Math.max(-prices[i], dp[i-1][1]);
            else dp[i][1] = Math.max(dp[i-1][1], -prices[i] + dp[i-2][0]);
            //if we do not have stock in hand, we have 2 choices:
            //Either we buy or not buy;
        }
        ans = Math.max(ans, dp[prices.length-1][0]);
        return ans;
    }
}

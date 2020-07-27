// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// here we can engage in multiple transactions.

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - prices[i-1] > 0)ans += prices[i] - prices[i-1];
        }
        return ans;
    }
}

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// here we can engage in multiple transactions and buy and sell on the same day.

// do this in interviews
class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, peak = -1, valley = -1, maxProfit = 0;
        
        while(i < prices.length-1){
            while(i < prices.length-1 && prices[i] >= prices[i+1])i++;
            
            valley = prices[i];
            
            while(i < prices.length-1 && prices[i] <= prices[i+1])i++;
            
            peak = prices[i];
            
            maxProfit += peak - valley;
        }
        return maxProfit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - prices[i-1] > 0)ans += prices[i] - prices[i-1];
        }
        return ans;
    }
}

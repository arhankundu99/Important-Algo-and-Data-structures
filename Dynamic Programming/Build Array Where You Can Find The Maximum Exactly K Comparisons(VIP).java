// https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/

class Solution {
    int M = 1000000007;
    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[n+1][m+1][k+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return dfs(0, 0, 0, n, m, k, dp);
    }
    public int dfs(int currLength, int currMax, int currCost, int n, int m, int k, int[][][]dp){
        if(currCost > k)return 0;
        if(currLength == n){
            if(currCost == k)return 1;
            return 0;
        }
        if(dp[currLength][currMax][currCost] != -1)return dp[currLength][currMax][currCost];
        
        int ans = 0;
        for(int i = 1; i <= m; i++){
            if(i > currMax){
                ans += dfs(currLength+1, i, currCost+1, n, m, k, dp);
                ans %= M;
            }
            else{
                ans += dfs(currLength+1, currMax, currCost, n, m, k, dp);
                ans %= M;
            }
        }
        dp[currLength][currMax][currCost] = ans;
        return ans;
    }
}

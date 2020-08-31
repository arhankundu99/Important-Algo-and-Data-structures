// https://leetcode.com/problems/dice-roll-simulation/
// top down dp (May give tle)
class Solution {
    int M = 1000000007;
    int[][][] dp;
    public int dieSimulator(int n, int[] rollMax) {
        dp = new int[7][16][n+1];
        
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 16; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return dfs(-1, 0, n, rollMax);   
    }   
    public int dfs(int left, int leftCount, int n, int[] rollMax){
        if(n == 0)return 1;
        long count = 0;
        
        if(left != -1 && dp[left][leftCount][n] != -1)return dp[left][leftCount][n];
        
        for(int i = 0; i < 6; i++){
            if(left != i + 1){
                count += dfs(i+1, 1, n-1, rollMax);
                count %= M;
            }
            else{
                if(leftCount == rollMax[i])continue;
                count += dfs(left, leftCount+1, n-1, rollMax);
                count %= M;
            }
        }
        if(left != -1)dp[left][leftCount][n] = (int)(count % M);
        return (int)(count % M);
    }
}

// bottom up
public int countDiceSubsequences(int n, int[] rollMax) {
        long p = 1_000_000_007;
        long[][] dp = new long[n + 1][6];
        long[] sum = new long[n+1];
        sum[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 6; ++j)  {
                for (int k = 1; k <= rollMax[j] && i - k >= 0; ++k)
                    dp[i][j] = (dp[i][j] + sum[i-k] - dp[i-k][j] + p) % p;
                sum[i] = (sum[i] + dp[i][j]) % p;
            }                
        }
        
        return (int) sum[n];
    }

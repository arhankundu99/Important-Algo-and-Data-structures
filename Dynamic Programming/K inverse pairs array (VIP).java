// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3784/
// DETAILED EXPLAINATION: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3784/discuss/1284885/This-is-a-wonderful-problem-or-Java-Solution
class Solution {
    
    long[][] dp;
    long[][] sum;
    int mod = (int)Math.pow(10, 9) + 7;
    
    public int kInversePairs(int n, int k) {
        
        dp = new long[1001][1001];
        sum = new long[1001][1001];
        
        for(int i = 1; i <= 1000; i++){
            for(int j = 0; j <= 1000; j++){
                
                if(j == 0){
                    dp[i][j] = 1;
                    sum[i][j] = 1 + sum[i - 1][j];
                }
                
                else if(j > (i * (i - 1)) / 2){
                    dp[i][j] = 0;
                    
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + mod;
                    sum[i][j] %= mod;
                }

                else {
                    dp[i][j] = sum[i - 1][j] - sum[i - 2][j] + mod - (j >= i? (sum[i - 1][j - i] - sum[i - 2][j - i]): 0);
                    dp[i][j] %= mod;
                    
                    sum[i][j] = dp[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + mod;;
                    sum[i][j] %= mod;
                }
            }    
        }
        return (int)dp[n][k];
    }
}

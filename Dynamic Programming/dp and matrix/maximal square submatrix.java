// https://leetcode.com/problems/maximal-square/
// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0)return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for(int i = 0; i < matrix.length; i++){
            dp[i][0] = matrix[i][0] - 48;
            if(dp[i][0] == 1)ans = 1;
        }
        for(int i = 0; i < matrix[0].length; i++){
            dp[0][i] = matrix[0][i] - 48;
            if(dp[0][i] == 1)ans = 1;
        }
        
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 49){
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans*ans;
    }
}

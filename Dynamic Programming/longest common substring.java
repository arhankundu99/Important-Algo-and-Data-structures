// [!Warning] doing this in top down approach will result in tle
// https://leetcode.com/problems/maximum-length-of-repeated-subarray/submissions/
class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        
        int ans = 0;
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                if(A[i] == B[j]){
                    dp[i][j] = (i == 0 || j == 0)?1: 1+dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}

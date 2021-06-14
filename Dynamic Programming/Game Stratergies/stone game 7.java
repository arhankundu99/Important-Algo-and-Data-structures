// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3775/
class Solution {
    int[][] dp;
    public int stoneGameVII(int[] stones) {
        //(A) -> Alice gets 0 and Bob gets 0 -> 0
        //(AB) -> Alice gets max(A, B) and Bob gets (0) -> max(A, B)
        //(ABC) -> Alice picks A -> Alice gets (B + C) -> Bob gets max (B, C) -> (B + C) - max(B, C)
        //      -> Alice picks C -> Alice gets (A + B) -> Bob gets max (A, B) -> (A + B) - max(A, B)
        //(s1......sn) -> Alice picks s1 -> (s2 + .... + sn) + (s2, s3,....sn);
        //             -> Alice picks sn -> (s1 + .... + sn-1) + (s1, ...., sn-1);
        
        dp = new int[stones.length][stones.length];
        
        for(int i = 0; i < stones.length; i++)Arrays.fill(dp[i], -1);
        
        int[] sum = new int[stones.length];
        sum[0] = stones[0];
        for(int i = 1; i < stones.length; i++)sum[i] = sum[i - 1] + stones[i];
        
        int ans = solve(stones, 0, stones.length - 1, sum);
        return ans;
    }
    
    public int solve(int[] stones, int start, int end, int[] sum){
        //base cases
        if(start == end)return 0;
        if(start == end - 1)return Math.max(stones[start], stones[end]);
        
        if(dp[start][end] != -1)return dp[start][end];
        
        //player picks start
        int score1 = sum[end] - sum[start] - solve(stones, start + 1, end, sum);
        
        //player picks end
        int score2 = sum[end - 1] - (start == 0? 0: sum[start - 1]) - solve(stones, start, end - 1, sum);
        
        return dp[start][end] = Math.max(score1, score2);
    }
}

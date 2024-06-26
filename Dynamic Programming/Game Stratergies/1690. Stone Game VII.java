// https://leetcode.com/problems/stone-game-vii/description/
class Solution {
    int[] prefixSum;
    int[][] dp;
    public int stoneGameVII(int[] stones) {
        prefixSum = new int[stones.length];
        dp = new int[stones.length][stones.length];

        for (int i = 0; i < stones.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        prefixSum[0] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            prefixSum[i] = stones[i] + prefixSum[i - 1];
        }
        int diff = getScoreDiff(stones, 0, stones.length - 1);
        return diff;
    }

    private int getScoreDiff(int[] stones, int left, int right) {
        if (left >= right) {
            return 0;
        }
        
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int score1 = prefixSum[right] - prefixSum[left];
        int score2 = prefixSum[right - 1] - (left - 1 >= 0? prefixSum[left - 1]: 0);
        return dp[left][right] = Math.max(score1 - getScoreDiff(stones, left + 1, right), score2 - getScoreDiff(stones, left, right - 1));
    }
}
// https://leetcode.com/problems/stone-game/description/
class Solution {
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        dp = new int[piles.length][piles.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return getScoreDiff(piles, 0, piles.length - 1) > 0? true: false;
    }

    private int getScoreDiff(int[] piles, int left, int right) {
        if (left > right) {
            return 0;
        }

        if (left == right) {
            return dp[left][right] = piles[left];
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        return dp[left][right] = Math.max(piles[left] - getScoreDiff(piles, left + 1, right), piles[right] - getScoreDiff(piles, left, right - 1));
    }
}
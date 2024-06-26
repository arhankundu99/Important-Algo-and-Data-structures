// https://leetcode.com/problems/stone-game-v/description/
class Solution {
    int[] prefixSum;
    int[][] dp;
    public int stoneGameV(int[] stoneValue) {
        prefixSum = new int[stoneValue.length];
        dp = new int[stoneValue.length][stoneValue.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        prefixSum[0] = stoneValue[0];
        for (int i = 1; i < stoneValue.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + stoneValue[i];
        }
        return stoneGame(stoneValue, 0, stoneValue.length - 1);
    }

    private int stoneGame(int[] stoneValue, int left, int right) {
        if (left == right || left > right) {
            return 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int maxScore = 0;
        for (int i = left; i <= right; i++) {
            int sum1 =  prefixSum[i] - (left == 0? 0: prefixSum[left - 1]);
            int sum2 = prefixSum[right] - prefixSum[i];
            // System.out.println("Left: " + left + " Right: " + right + " idx: " + i + " sum1: " + sum1 + " sum2: " + sum2);

            if (sum1 > sum2) {
                maxScore = Math.max(maxScore, sum2 + stoneGame(stoneValue, i + 1, right));
            } else if (sum1 == sum2) {
                maxScore = Math.max(maxScore, Math.max(sum1 + stoneGame(stoneValue, left, i), sum2 + stoneGame(stoneValue, i + 1, right)));
            } else {
                maxScore = Math.max(maxScore, sum1 + stoneGame(stoneValue, left, i));
            }
        }
        return dp[left][right] = maxScore;
    }
}
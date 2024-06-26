// https://leetcode.com/problems/stone-game-ii/description/
class Solution {
    Map<Integer, Map<Integer, Integer>> dp;
    public int stoneGameII(int[] piles) {
        dp = new HashMap<>();
        int scoreDiff = getScoreDiff(piles, 0, 1);

        int pilesSum = 0;
        for (int pile: piles) {
            pilesSum += pile;
        }

        return (pilesSum + scoreDiff) / 2;
    }

    private int getScoreDiff(int[] piles, int currIdx, int M) {
        if (currIdx >= piles.length) {
            return 0;
        }
        if (dp.containsKey(currIdx) && dp.get(currIdx).containsKey(M)) {
            return dp.get(currIdx).get(M);
        }
        int pilesSum = 0;
        int maxScoreDiff = Integer.MIN_VALUE;
        for (int X = 1; X <= 2 * M && currIdx + X - 1 < piles.length; X++) {
            pilesSum += piles[currIdx + X - 1];
            int scoreDiff = pilesSum - getScoreDiff(piles, currIdx + X, Math.max(M, X));
            maxScoreDiff = Math.max(maxScoreDiff, scoreDiff);
        }
        if (!dp.containsKey(currIdx)) {
            dp.put(currIdx, new HashMap<>());
        }
        dp.get(currIdx).put(M, maxScoreDiff);
        return maxScoreDiff;
    }
}
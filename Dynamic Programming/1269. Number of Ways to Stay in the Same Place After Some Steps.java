// https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/?envType=daily-question&envId=2023-10-15
class Solution {
    private final int MOD = (int)(Math.pow(10, 9) + 7);
    public int numWays(int steps, int arrLen) {
        // why is the second parameter of dp array steps + 1 and not arrLen? because the maximum idx we can go in the
        // array is at min(steps. arrLen) idx, because if we go more than that, then we will not be able to come at 0th idx
        int[][] dp = new int[steps + 1][steps + 1];
        for(int i = 0; i < steps + 1; i++){
            Arrays.fill(dp[i], -1);
        }
        return numWays(steps, arrLen, 0, dp);
    }

    private int numWays(int steps, int arrLen, int currIdx, int[][] dp){
        if(currIdx < 0 || currIdx == arrLen || currIdx > dp.length){
            return 0;
        }

        if(steps == 0){
            if(currIdx == 0){
                return 1;
            }
            return 0;
        }

        if(dp[steps][currIdx] != -1){
            return dp[steps][currIdx];
        }

        int[] moves = new int[]{-1, 0, 1};
        
        long waysCount = 0;
        for(int move: moves){
            waysCount += numWays(steps - 1, arrLen, currIdx + move, dp);
            waysCount %= MOD;
        }
        return dp[steps][currIdx] = (int)waysCount;
    }
}
// https://leetcode.com/problems/2-keys-keyboard/description/

class Solution {
    int total;
    public int minSteps(int n) {
        this.total = n;
        if (n == 1) {
            return 0;
        }
        return minStepsHelper(n - 1, 0);
    }

    private int minStepsHelper(int n, int numCharsCopiedPreviously) {
        if (n == 0) {
            return 0;
        }

        int numSteps = Integer.MAX_VALUE;

        // Copy all and paste
        int numCharsCopiedNow = (total - n);
        
        if (n - numCharsCopiedNow >= 0 && numCharsCopiedNow != 0) {
            numSteps = minStepsHelper(n - numCharsCopiedNow, numCharsCopiedNow);
            if (numSteps != Integer.MAX_VALUE) {
                numSteps += 2;
            }
        }

        if (n - numCharsCopiedPreviously >= 0 && numCharsCopiedPreviously != 0) {
            // paste previous
            int steps = minStepsHelper(n - numCharsCopiedPreviously, numCharsCopiedPreviously);
            if (steps != Integer.MAX_VALUE) {
                numSteps = Math.min(numSteps, steps + 1);
            }
        }

        return numSteps;
    }
}

// Using bottom up
class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + (i / j));
                }
            }
        }
        return dp[n];
    }
}
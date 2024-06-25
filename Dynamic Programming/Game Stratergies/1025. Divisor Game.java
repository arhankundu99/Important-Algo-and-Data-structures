// https://leetcode.com/problems/divisor-game/description/
class Solution {
    public boolean divisorGame(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return divisorGame(n, 0, dp);
    }

    private boolean divisorGame(int n, int player, int[] dp) {
        if (n <= 1) {
            return false;
        }

        if (dp[n] != Integer.MAX_VALUE) {
            return dp[n] == 1? true: false;
        }

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (!divisorGame(n - i, 1 - player, dp)) {
                    dp[n] = 1;
                    return true;
                }
                
                
                if (i != 1 && !divisorGame(n - (n / i), 1 - player, dp)) {
                    dp[n] = 1;
                    return true;
                }
            }
        }
        dp[n] = 0;
        return false;
    }
}

// Notice that there is no dependency of currPlayer, so we can safely remove it
class Solution {
    public boolean divisorGame(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return divisorGame(n, dp);
    }

    private boolean divisorGame(int n, int[] dp) {
        if (n <= 1) {
            return false;
        }

        if (dp[n] != Integer.MAX_VALUE) {
            return dp[n] == 1? true: false;
        }

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (!divisorGame(n - i, dp)) {
                    dp[n] = 1;
                    return true;
                }
                
                
                if (i != 1 && !divisorGame(n - (n / i), dp)) {
                    dp[n] = 1;
                    return true;
                }
            }
        }
        dp[n] = 0;
        return false;
    }
}
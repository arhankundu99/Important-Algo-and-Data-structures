// https://leetcode.com/problems/stone-game-iv/
// Further optimise the solution by removing currPlayer field and using dp
class Solution {
    public boolean winnerSquareGame(int n) {
        return winnerSquareGame(n, 0);   
    }

    private boolean winnerSquareGame(int n, int currPlayer) {
        if (n == 0) {
            return false;
        }

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (!winnerSquareGame(n - i * i, 1 - currPlayer)) {
                return true;
            }
        }
        return false;
    }
}


class Solution {
    public boolean winnerSquareGame(int n) {
        Map<Integer, Boolean> dp = new HashMap<>();
        return winnerSquareGame(n, dp);
    }

    private boolean winnerSquareGame(int n, Map<Integer, Boolean> dp) {
        if (n == 0) {
            return false;
        }

        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (!winnerSquareGame(n - i * i, dp)) {
                dp.put(n, true);
                return true;
            }
        }
        dp.put(n, false);
        return false;
    }
}
// https://leetcode.com/discuss/interview-question/4422524/Google-Onsite-interview/2174916
// Variation of coin change.
// we are given dp array that we created while finding number of ways to make the target sum. We need to find the coins array, using which this dp array is created.
// Example:

// target = 10
// number of ways to make 10: 3
// Input: [1, 0, 1, 0, 1, 1, 2, 1, 2, 1, 3]
// Output: [2, 5, 6]
class Solution {
    int[] getCoins(int[] dp) {
        List<Integer> coinsList = new ArrayList<>();
        
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] == 1) {
                coinsList.add(i);
                
                for (int j = dp.length - 1; j >= i; j--) {
                    dp[j] -= dp[j - i];
                }
            }
        }
        int[] coins = new int[coinsList.size()];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = coinsList.get(i);
        }
        return coins;
    }

    int[] getDPArray(int[] nums, int target) {
        // Define a dp array where dp[i] = number of ways to make amount i
        int[][] dp = new int[target + 1][nums.length];
        // Base case 
        for (int j = 0; j < nums.length; j++) {
            dp[0][j] = 1;
        }
        
        // dp[amount][idx] = dp[amount][idx + 1] + dp[amount - coins[idx]][idx];

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 1; j <= target; j++) {
                if (i + 1 < nums.length) {
                    dp[j][i] += dp[j][i + 1];
                }
                
                if (j - nums[i] >= 0) {
                    dp[j][i] += dp[j - nums[i]][i];
                }
            }
        }
        int[] result = new int[target + 1];
        for (int i = 0; i <= target; i++) {
            result[i] = dp[i][0];
        }
        return result;
    }

    int[] getDPArraySpaceOptimised(int[] nums, int target) {
        // Define a dp array where dp[i] = number of ways to make amount i
        int[] dp = new int[target + 1];
        // Base case 
        dp[0] = 1;

        // now for each amount
        // dp[amount] += dp[amount - coins[j]]

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j - nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] dpArray = ((new Solution()).getDPArray(new int[]{2, 5, 6}, 10));
        for (int i = 0; i < dpArray.length; i++) {
            System.out.print(dpArray[i] + " ");
        }
        System.out.println();
        int[] coins = ((new Solution()).getCoins(new int[]{1, 0, 1, 0, 1, 1, 2, 1, 2, 1, 3}));
        for (int coin: coins) {
            System.out.println(coin);
        }
    }
}
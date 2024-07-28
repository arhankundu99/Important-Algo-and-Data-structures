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
}
public class Main {
    public static void main(String[] args) {
        int[] coins = ((new Solution()).getCoins(new int[]{1, 0, 1, 0, 1, 1, 2, 1, 2, 1, 3}));
        for (int coin: coins) {
            System.out.println(coin);
        }
    }
}
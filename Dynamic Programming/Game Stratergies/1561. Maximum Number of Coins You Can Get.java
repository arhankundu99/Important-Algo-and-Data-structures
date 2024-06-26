// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int coinsCount = 0;
        int i = 0, j = piles.length - 2, k = piles.length - 1;
        while(i < j){
            coinsCount += piles[j];
            i++;
            j -= 2;
            k -= 2;
        }
        return coinsCount;
    }
}
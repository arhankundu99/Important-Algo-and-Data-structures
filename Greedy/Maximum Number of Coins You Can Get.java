// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        
        int length = piles.length, sum = 0;
        for(int i = piles.length-2; i >= 0 && length > 0; i -= 2){
            sum += piles[i];
            length -= 3;
        }
        return sum;
    }
}

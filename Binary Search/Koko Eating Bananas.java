// https://leetcode.com/problems/koko-eating-bananas/description/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //Note that the eating speed of Koko will lie between min(piles[i]) and max(piles[i])
        
        
        int low = 1;
        int high = (int)Math.pow(10, 9);
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            int time = 0;
            for(int i = 0; i < piles.length; i++){
               time += (piles[i] / mid) + ((piles[i] % mid) != 0? 1: 0);
                
            }
            if(time > h){
                low = mid + 1;
            }
            else{
               ans = mid; 
                high = mid - 1;
            }
        }
        return ans;
    }
}

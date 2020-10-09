// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
class Solution {
    public int getMaxLen(int[] nums) {
        if(nums.length == 0)return 0;
        
        //pos[i] denotes the length of longest subarray with positive product ending at ith idx
        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];
        
        int maxLen = 0;
        if(nums[0] > 0){
            pos[0] = 1;
            maxLen = 1;
        }
        if(nums[0] < 0)neg[0] = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > 0){
                pos[i] = 1 + pos[i-1];
                neg[i] = neg[i-1] > 0? neg[i-1] + 1: 0;
            }
            if(nums[i] < 0){
                pos[i] = neg[i-1] > 0? 1 + neg[i-1]: 0;
                neg[i] = 1 + pos[i-1];
            }
            maxLen = Math.max(maxLen, pos[i]);
        }
        return maxLen;
    }
}

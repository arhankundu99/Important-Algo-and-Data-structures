//Problem number 209
//Given an array of n positive integers and a positive integer s, 
//find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int idx1=0,idx2=0;
        int currSum=0;
        int ret=Integer.MAX_VALUE;
        while(idx2<nums.length)
        {
            currSum+=nums[idx2];
            idx2++;
            if(currSum>=s)
            {
                while(currSum>=s)
                {
                    currSum-=nums[idx1];
                    idx1++;
                }
                ret=Math.min(ret,idx2-idx1+1);
            }
        }
        return ret==Integer.MAX_VALUE?0:ret;
    }
}
// Idea - Sliding window Approach

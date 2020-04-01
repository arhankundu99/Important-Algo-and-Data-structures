//Prob number 53
//Given an integer array nums, 
//find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

class Solution {
    public int maxSubArray(int[] nums) {
        int idx=0;
        int currSum=0,maxSum=Integer.MIN_VALUE;
        while(idx<nums.length)
        {
            currSum+=nums[idx];
            maxSum = Math.max(currSum,maxSum);
            if(currSum<0)currSum=0;
            idx++;
        }
        return maxSum;
    }
}

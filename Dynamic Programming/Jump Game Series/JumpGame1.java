//Given an array of non-negative integers, you are initially positioned at the first index of the array.

//Each element in the array represents your maximum jump length at that position.

//Determine if you are able to reach the last index.

class Solution {
    public boolean canJump(int[] nums) {
        int[]dp = new int[nums.length];
        for(int i=1;i<nums.length;i++)dp[i]=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++)
        {
            int minJump = Integer.MAX_VALUE;
            for(int j=0;j<i;j++)
            {
                if(j+nums[j]>=i)
                {
                    minJump = Math.min(dp[j], minJump);
                    break;
                }
            }
            if(minJump != Integer.MAX_VALUE)dp[i] = 1+minJump;
        }
        return dp[nums.length-1]==Integer.MAX_VALUE?false:true;
    }
}

//dp[i] represents the minimum number of jumps to reach tile i. 

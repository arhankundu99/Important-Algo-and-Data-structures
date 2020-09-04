//Given an array of non-negative integers, you are initially positioned at the first index of the array.

//Each element in the array represents your maximum jump length at that position.

//Determine if you are able to reach the last index.

//solution 1: Top Down Memoization (TLE) O(N*Max(nums[i]))
class Solution {
    int[] dp;
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return canJump(nums, 0);
    }
    public boolean canJump(int[] nums, int idx){
        if(idx >= nums.length-1)return true;
        
        if(dp[idx] == 0)return false;
        if(dp[idx] == 1)return true;
        
        for(int i = 1; i <= nums[idx]; i++){
            if(canJump(nums, idx+i)){
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 0;
        return false;
    }
}

// solution 2: O(N^2) Bottom up. TLE
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

//greedy O(n) solution
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(i > max)return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}

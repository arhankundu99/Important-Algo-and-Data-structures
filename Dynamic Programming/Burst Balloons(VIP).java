// https://leetcode.com/problems/burst-balloons/description/
Top Down Approach: O(N^3) Time and O(N^2) Space due to DP Array and stack space of recursion

class Solution {
    public int maxCoins(int[] nums) {
        //TopDown Approach
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++)Arrays.fill(dp[i], -1);
        
        return maxCoinsTopDown(nums, 0, nums.length - 1, dp);
    }
    public int maxCoinsTopDown(int[] nums, int leftIdx, int rightIdx, int[][] dp){
        //base case
        if(leftIdx > rightIdx)return 0;
        if(dp[leftIdx][rightIdx] != -1)return dp[leftIdx][rightIdx];
        
        int leftBoundary = leftIdx != 0? nums[leftIdx - 1]: 1;
        int rightBoundary = rightIdx != nums.length - 1? nums[rightIdx + 1]: 1;
        
        if(leftIdx == rightIdx)return dp[leftIdx][rightIdx] = leftBoundary * nums[leftIdx] * rightBoundary;
        
        int maxCoins = 0;
        for(int lastBalloonIdx = leftIdx; lastBalloonIdx <= rightIdx; lastBalloonIdx++){
            
            //picking the balloon at lastBalloonIdx to be the last balloon to be burst
            //among the balloons in the range leftIdx to rightIdx
            
            maxCoins = Math.max(maxCoins, leftBoundary * nums[lastBalloonIdx] * rightBoundary + 
                               maxCoinsTopDown(nums, leftIdx, lastBalloonIdx - 1, dp) + 
                               maxCoinsTopDown(nums, lastBalloonIdx + 1, rightIdx, dp));
        }
        return dp[leftIdx][rightIdx] = maxCoins;
    }
}
Bottom Up Approach: O(N^3) time and O(N^2) space due to DP Array

class Solution {
    public int maxCoins(int[] nums) {
        //bottomUp Approach
        int[][] dp = new int[nums.length][nums.length];
        
        for(int len = 1; len <= nums.length; len++){
            for(int i = 0; i < nums.length + 1 - len; i++){
                
                int leftBoundary = (i != 0)? nums[i - 1]: 1;
                int rightBoundary = (i + len < nums.length)? nums[i + len]: 1;
                
                int k = i + len - 1;
                for(int j = i; j <= k; j++){
                    //in the range of balloons from i to k, picking the balloon at jth
                    //idx to be the last balloon to burst
                    dp[i][k] = Math.max(dp[i][k],
                                        leftBoundary * nums[j] * rightBoundary + 
                                        (j > 0? dp[i][j - 1]: 0) + 
                                        (j < nums.length - 1? dp[j + 1][k]: 0));
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}

https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
Time: O(k^n)

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++)sum += nums[i];
        
        if(sum % k != 0)return false;
        
        return canPartition(nums, k, 0, sum/k, 0, nums.length-1);
    }
    public boolean canPartition(int[] nums, int k, int mask, int sum, int currSum, int idx){
        if(currSum > sum)return false;
        if(k == 0)return true;
        
        if(currSum == sum)return canPartition(nums, k-1, mask, sum, 0, nums.length-1);
        
        for(int i = idx; i >= 0; i--){
            if((mask & (1<<i)) != 0)continue;
            
            if(canPartition(nums, k, mask | (1<<i), sum, currSum+nums[i], i-1))return true;
        }
        return false;
    }
}

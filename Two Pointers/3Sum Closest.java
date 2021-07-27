// https://leetcode.com/problems/3sum-closest/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int maxSum = Integer.MIN_VALUE, minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int j = i + 1, k = nums.length - 1;
            
            while(j < k){
                int currSum = nums[i] + nums[j] + nums[k];
                int absDiff = Math.abs(currSum - target);
                
                if(absDiff < minDiff){
                    minDiff = absDiff;
                    maxSum = currSum;
                }
                
                if(currSum > target)k--;
                else j++;
            }
        }
        return maxSum;
    }
}

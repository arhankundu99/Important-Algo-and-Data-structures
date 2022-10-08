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

//same solution
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int threeSumClosest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++){
            int sum = nums[i] + twoSumClosest(nums, target - nums[i], i + 1);
            if(Math.abs(sum - target) < Math.abs(threeSumClosest - target)){
                threeSumClosest = sum;
            }
        }
        return threeSumClosest;
    }

    private int twoSumClosest(int[] nums, int target, int start){
        int twoSumClosest = nums[start] + nums[start + 1];

        int low = start, high = nums.length - 1;

        while(low < high){
            int sum = nums[low] + nums[high];

            if(Math.abs(sum - target) < Math.abs(twoSumClosest - target)){
                twoSumClosest = sum;
            }

            if(sum > target){
                high--;
            }
            else low++;
        }
        
        return twoSumClosest;
    }
}

// https://leetcode.com/problems/increasing-triplet-subsequence/

//Solution 1 
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3)
            return false;

        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(firstMin >= nums[i]){
                firstMin = nums[i];
            }
            else if(secondMin >= nums[i]){
                secondMin = nums[i];
            }
            else return true;
        }

        return false;
    }
}


//Solution 2
class Solution {
    public boolean increasingTriplet(int[] nums) {

        int[] max = new int[nums.length];

        max[max.length - 1] = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--){
            max[i] = Math.max(max[i + 1], nums[i]);
        }

        int min = nums[0];
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] > min && max[i + 1] > nums[i])
                return true;
            min = Math.min(min, nums[i]);
        }
        return false;
    }
}

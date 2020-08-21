// https://leetcode.com/problems/first-missing-positive/
class Solution {
    public int firstMissingPositive(int[] nums) {
        
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != i+1){
                if(nums[i] == nums[nums[i]-1])break;
                swap(nums, i, nums[i]-1);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1)return i+1;
        }
        return nums.length+1;
    }
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

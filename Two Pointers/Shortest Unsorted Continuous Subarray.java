// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0, right = nums.length-1;
        
        while(left + 1 < nums.length && nums[left] <= nums[left+1])left++;
        while(right - 1 >= 0 && nums[right] >= nums[right-1])right--;
        
        if(left == nums.length-1)return 0;
        
        
        Arrays.sort(nums, left, right+1);
        
        int minLength = right - left + 1;
        
        // if there is an element smaller than nums[i] in the range [left, right], we have to include the element also
        for(int i = left-1; i >= 0; i--){
            if(nums[left] < nums[i])minLength++;
        }
        
        // include the element which is greater than nums[i] in the range [left, right]
        for(int i = right + 1; i < nums.length; i++){
            if(nums[i] < nums[right])minLength++;
        }
        
        return minLength;
    }
}

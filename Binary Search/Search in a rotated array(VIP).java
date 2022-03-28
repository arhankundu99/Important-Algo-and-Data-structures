// https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
    public int search(int[] nums, int target) {
        
        int low = 0, high = nums.length - 1;
        
        int pivotIndex = getPivot(nums);
        
        if(nums[high] >= target)return search(nums, pivotIndex, nums.length - 1, target);
        
        return search(nums, 0, pivotIndex - 1, target);
    }
    
    public int getPivot(int[] nums){
        int low = 0, high = nums.length - 1;
        
        while(low < high){
            int mid = low + (high - low) / 2;
            
            if(nums[mid] > nums[high])low = mid + 1;
            else high = mid;
        }
        return high;
    }
    
    public int search(int[] nums, int low, int high, int target){
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target)return mid;
            else if(nums[mid] > target)high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}

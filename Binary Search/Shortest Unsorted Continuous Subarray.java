// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0, right = nums.length-1;
        
        while(left + 1 < nums.length && nums[left] <= nums[left+1])left++;
        while(right - 1 >= 0 && nums[right] >= nums[right-1])right--;
        
        if(left == nums.length-1)return 0;
        
        Arrays.sort(nums, left, right+1);
        
        int minLength = right - left + 1;
        
        for(int i = left-1; i >= 0; i--){
            if(binarySearch(nums, nums[i], left, right, false))minLength++;
        }
        
        for(int i = right + 1; i < nums.length; i++){
            if(binarySearch(nums, nums[i], left, right, true))minLength++;
        }
        return minLength;
    }
    public boolean binarySearch(int[] arr, int val, int low, int high, boolean flag){
        
        while(low <= high){
            int mid = (low + high)/2;
            
            if(!flag){
                if(arr[mid] < val)return true;
                else high = mid - 1;
            }
            else{
                if(arr[mid] > val)return true;
                else low = mid + 1;
            }
        }
        return false;
    }
}

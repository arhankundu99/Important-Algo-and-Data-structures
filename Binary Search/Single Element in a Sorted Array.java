// https://leetcode.com/problems/single-element-in-a-sorted-array/description/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)return nums[0];
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(mid == nums.length - 1)return nums[mid];
            if(mid % 2 == 0){
                if(mid != 0 && nums[mid] == nums[mid - 1]){
                    high = mid - 1;
                    continue;
                 }
                if(nums[mid] != nums[mid + 1])return nums[mid];
                low = mid + 1;
            }
            else{
                if(nums[mid] == nums[mid - 1])low = mid + 1;
                else high = mid - 1;
                
            }
            
        }
        return -1;
    }
}

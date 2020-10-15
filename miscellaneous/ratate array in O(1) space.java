// https://leetcode.com/problems/rotate-array/
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public void reverse(int[] nums, int idx1, int idx2){
        while(idx1 < idx2){
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
            
            idx1++;
            idx2--;
        }
    }
}

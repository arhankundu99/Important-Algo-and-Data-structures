// https://leetcode.com/problems/shuffle-an-array/
class Solution {
    int[] origConfig;
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
        origConfig = new int[nums.length];
        for(int i = 0; i < nums.length; i++)origConfig[i] = nums[i];
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origConfig;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < nums.length; i++){
            //select a random idx between i and nums.length - 1;
            int randomIdx = (int)(Math.random() * (nums.length - i)) + i;
            
            int temp = nums[i];
            nums[i] = nums[randomIdx];
            nums[randomIdx] = temp;
        }
        return nums;
    }
}

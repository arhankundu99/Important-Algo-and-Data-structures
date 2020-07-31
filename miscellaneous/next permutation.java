// https://leetcode.com/problems/next-permutation/
class Solution {
    public void nextPermutation(int[] nums) {
        boolean flag = true;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i+1]){
                flag = false;
                break;
            }
        }
        if(flag){
            Arrays.sort(nums);
            return;
        }
        for(int i = nums.length-1; i > 0; i--){
            if(nums[i-1] < nums[i]){
                int idx = findNextGreaterIdx(nums, i-1);
                swap(nums, i-1, idx);
                sort(nums, i);
                return;
            }
        }
    }
    public int findNextGreaterIdx(int[] nums, int idx){
        int idx2 = idx+1;
        int diff = nums[idx2] - nums[idx];
        
        for(int i = idx2+1; i < nums.length; i++){
            if(nums[i] > nums[idx] && diff > nums[i] - nums[idx]){
                diff = nums[i] - nums[idx];
                idx2 = i;
            }
        }
        return idx2;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sort(int[] nums, int idx){
        int[] temp = new int[nums.length - idx];
        for(int i = idx; i < nums.length; i++){
            temp[i - idx] = nums[i];
        }
        Arrays.sort(temp);
        for(int i = idx; i < nums.length; i++){
            nums[i] = temp[i - idx];
        }
    }
}

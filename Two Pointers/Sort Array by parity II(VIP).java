// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3990/
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int evenIdx = 0, oddIdx = 1;
        while(evenIdx < nums.length && oddIdx < nums.length){
            while(evenIdx < nums.length && nums[evenIdx] % 2 == 0)evenIdx += 2;
            while(oddIdx < nums.length && nums[oddIdx] % 2 != 0)oddIdx += 2;
            
            if(evenIdx < nums.length && oddIdx < nums.length)swap(nums, evenIdx, oddIdx);
        }
        return nums;
    }
    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}

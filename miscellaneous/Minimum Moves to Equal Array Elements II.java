// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
// reason for choosing median: https://math.stackexchange.com/questions/113270/the-median-minimizes-the-sum-of-absolute-deviations-the-ell-1-norm
// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/94932/Why-median-is-better-than-average
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median;
        if(nums.length % 2 != 0)median = nums[nums.length / 2];
        else median = ( nums[nums.length/2 - 1] + nums[nums.length / 2] ) / 2;
            
        return solve(nums, median);        
        
    }
    public int solve(int[] nums, int x){
        int moves = 0;
        for(int num: nums)moves += Math.abs(num - x);
        return moves;
    }
}

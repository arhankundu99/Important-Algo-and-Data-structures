// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
class Solution {
    //idea: Increasing n - 1 elements by 1 is equal to decreasing 1 element by 1 
    public int minMoves(int[] nums) {
        if(nums.length <= 1)return 0;
        int moves = 0;
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            min = Math.min(nums[i], min);
        }
        for(int i = 0; i < nums.length; i++)moves += nums[i] - min;
        return moves;
        
    }
}

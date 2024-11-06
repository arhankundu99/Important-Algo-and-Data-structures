// Problem 462
// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
class Solution {
    public int minMoves2(int[] nums) {

            
        Arrays.sort(nums);
        
        long sum = sum(nums), runningSum = 0;
        
        long minMoves = Long.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            runningSum += nums[i];
            
            long moves = sum - (1L * nums.length * nums[i]) - (2L * runningSum) + (2L * (i + 1) * nums[i]);
            
            minMoves = Math.min(minMoves, moves);
        }
        
        return (int)minMoves;
    }
    
    public long sum(int[] nums){
        long sum = 0;
        for(int num: nums)sum += num;
        return sum;
    }
}

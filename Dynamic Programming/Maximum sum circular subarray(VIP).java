// https://leetcode.com/problems/maximum-sum-circular-subarray/
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int currMaxSum = 0, currMinSum = 0, maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE, totalSum = 0;
        boolean flag = true;
        // flag to check whether all elements are negative or not
        
        for(int i = 0; i < A.length; i++){
            currMaxSum += A[i];
            maxSum = Math.max(maxSum, currMaxSum);
            if(currMaxSum < 0)currMaxSum = 0;
            
            totalSum += A[i];
            if(A[i] >= 0)flag = false;
            
            currMinSum += A[i];
            minSum = Math.min(currMinSum, minSum);
            if(currMinSum > 0)currMinSum = 0;
            
        }
        if(flag)return maxSum;
        return Math.max(totalSum - minSum, maxSum);
    }
}

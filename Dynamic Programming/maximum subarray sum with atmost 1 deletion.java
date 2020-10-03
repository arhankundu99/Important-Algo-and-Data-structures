// https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
class Solution {
    public int maximumSum(int[] arr) {
        int[] dp1 = new int[arr.length];
        
        dp1[0] = arr[0];
        int max = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            dp1[i] = Math.max(arr[i], arr[i]+dp1[i-1]);
            max = Math.max(max, dp1[i]);
        }
        
        int[] dp2 = new int[arr.length];
        dp2[arr.length-1] = arr[arr.length-1];
        
        for(int i = arr.length-2; i >= 0; i--){
            dp2[i] = Math.max(arr[i], arr[i] + dp2[i+1]);
        }
        
        for(int i = 1; i < arr.length-1; i++){
            if(arr[i] < 0){
                max = Math.max(max, dp1[i-1] + dp2[i+1]);
            }
        }
        return max;
    }
}

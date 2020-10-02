// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        return solve(nums);

    }    
    public int solve(int[] arr){
        int left = arr.length - 1, right = 0;
        Stack<Integer>stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++){
            if(stack.size() == 0 || arr[stack.peek()] <= arr[i])stack.push(i);
            else{
                while(stack.size() != 0 && arr[i] < arr[stack.peek()]){
                    left = Math.min(left, stack.pop());
                }
                stack.push(i);
            }
        }
        stack = new Stack<>();
        
        for(int i = arr.length-1; i >= 0; i--){
            if(stack.size() == 0 || arr[stack.peek()] >= arr[i])stack.push(i);
            else{
                while(stack.size() != 0 && arr[stack.peek()] < arr[i]){
                    right = Math.max(right, stack.pop());
                }
                stack.push(i);
            }
        }
        if(right == left)return 0;
        int minLength = right - left + 1;
        return minLength >= 0? minLength: 0;
    }
}    

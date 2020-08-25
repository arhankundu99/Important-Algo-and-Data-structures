// https://leetcode.com/problems/next-greater-element-ii/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<pair>stack = new Stack<>();
        int[] ans = new int[nums.length];
        
        Arrays.fill(ans, -1);
        
        for(int i = 0; i < 2*nums.length; i++){
            int idx = i % nums.length;
            if(stack.size() == 0 || stack.peek().val >= nums[idx])stack.push(new pair(nums[idx], idx));
            
            else{
                while(stack.size() != 0 && stack.peek().val < nums[idx]){
                    ans[stack.peek().idx] = nums[idx];
                    stack.pop();
                }
                stack.push(new pair(nums[idx], idx));
            }
        }
        return ans;
    }
}
class pair{
    int val, idx;
    pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}

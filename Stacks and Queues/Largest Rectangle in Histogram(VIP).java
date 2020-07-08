//https://leetcode.com/problems/largest-rectangle-in-histogram/
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>stack = new Stack<>();
        int idx = 0;
        int ans = 0;
        while(idx < heights.length){
            if(stack.isEmpty() || heights[stack.peek()] <= heights[idx])
                stack.push(idx++);
            else{
                int popIdx = stack.pop();
                int width = stack.isEmpty()?idx: idx-stack.peek()-1;
                int area = heights[popIdx]*width;
                System.out.println(popIdx+" "+area);
                ans = Math.max(ans, area);
            }
        }
        while(!stack.isEmpty()){
            int popIdx = stack.pop();
            int width = stack.isEmpty()?idx: idx-stack.peek()-1;
            ans = Math.max(ans, heights[popIdx]*width);
        }
        return ans;
    }
}

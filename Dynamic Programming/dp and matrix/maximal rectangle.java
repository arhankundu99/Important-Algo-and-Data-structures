//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//https://leetcode.com/problems/maximal-rectangle/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)return 0;
        int ans = 0;
        int[][] a = new int[matrix.length][matrix[0].length];
        
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                a[i][j] = matrix[i][j] - 48;
            }
        }
        
        ans = Math.max(ans, largestAreaUnderHistogram(a[0]));
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                a[i][j] = a[i][j] == 0?0: a[i][j] + a[i-1][j];
            }
            ans = Math.max(ans, largestAreaUnderHistogram(a[i]));
        }
        return ans;
    }
    public int largestAreaUnderHistogram(int[]a){
        Stack<Integer>stack = new Stack<>();
        int idx = 0;
        int area = 0;
        while(idx < a.length){
            if(stack.isEmpty() || a[stack.peek()] <= a[idx])stack.push(idx++);
            else{
                int height = a[stack.pop()];
                int width = stack.isEmpty() ? idx: idx-stack.peek()-1;
                area = Math.max(area, height*width);
            }
        }
        while(!stack.isEmpty()){
            int height = a[stack.pop()];
            int width = stack.isEmpty() ? idx: idx-stack.peek()-1;
            area = Math.max(area, height*width);
        }
        return area;
    }
}

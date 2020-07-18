// https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int r = 0;
                while(r < matrix.length){
                    int sum = 0;
                    for(int k = r; k < matrix.length; k++){
                        if(i > 0)sum += matrix[k][j] - matrix[k][i-1];
                        else sum += matrix[k][j];
                        if(sum <= target)ans = Math.max(ans, sum);
                    }
                    r++;
                }
            }
        }
        return ans;
        
    }
}

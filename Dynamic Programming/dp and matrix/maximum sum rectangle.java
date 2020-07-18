// https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle/0
// Idea inspired from: https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/discuss/303750/JavaC%2B%2BPython-Find-the-Subarray-with-Target-Sum

   public static int maxSumSubmatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int sum = 0;
                for(int k = 0; k < matrix.length; k++){
                    if(i > 0)sum += matrix[k][j] - matrix[k][i-1];
                    else sum += matrix[k][j];
                    ans = Math.max(ans, sum);
                    if(sum < 0)sum = 0;
                }
            }
        }
        return ans;
        
    }

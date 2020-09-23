// https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
// O(n^3logn) solution
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int c1 = 0; c1 < matrix[0].length; c1++){
            for(int c2 = c1; c2 < matrix[0].length; c2++){
                
                TreeSet<Integer>set = new TreeSet<>();
                int sum = 0;
                set.add(0);
                
                for(int r = 0; r < matrix.length; r++){
                    sum += (c1 == 0)? matrix[r][c2]: matrix[r][c2] - matrix[r][c1-1];
                    Integer find = set.ceiling(sum - k);
                        
                    if(find != null)ans = Math.max(ans, sum - find);
                    set.add(sum);
                }
            }
        }
        return ans;
    }
}

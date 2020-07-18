// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
// Explaination: https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/discuss/303750/JavaC%2B%2BPython-Find-the-Subarray-with-Target-Sum

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        int count = 0;
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = i; j < matrix[0].length; j++){
                Map<Integer, Integer>map = new HashMap<>();
                int sum = 0;
                for(int k = 0; k < matrix.length; k++){
                    if(i > 0)sum += matrix[k][j] - matrix[k][i-1];
                    else sum += matrix[k][j];
                    
                    if(sum == target){
                        count++;
                        if(map.containsKey(0))count += map.get(0);
                    }
                    
                    else if(map.containsKey(sum-target)){
                        count += map.get(sum-target);
                    }
                    if(!map.containsKey(sum))map.put(sum, 1);
                    else map.put(sum, map.get(sum)+1);
                }
            }
        }
        return  count;
    }
}

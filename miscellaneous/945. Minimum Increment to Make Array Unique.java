// https://leetcode.com/problems/minimum-increment-to-make-array-unique/
class Solution {
    public int minIncrementForUnique(int[] A) {
        if(A.length <= 1)return 0;
        Arrays.sort(A);
        int currMax = A[0];
        int count = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i] > currMax){
                currMax = A[i];
            }
            else{
                currMax++;
                count += currMax - A[i];
            }
        }
        return count;
    }
}

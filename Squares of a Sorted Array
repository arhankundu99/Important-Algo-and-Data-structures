//Given an array of integers A sorted in non-decreasing order, 
//return an array of the squares of each number, also in sorted non-decreasing order.

class Solution {
    public int[] sortedSquares(int[] A) {
        int idx1 = 0, idx2 = A.length-1;
        int[]ret = new int[A.length];
        int currIdx=A.length-1;
        while(idx1<=idx2)
        {
            if(Math.abs(A[idx1])>Math.abs(A[idx2]))
            {
                ret[currIdx--]=A[idx1]*A[idx1];
                idx1++;
            }
            else
            {
                ret[currIdx--]=A[idx2]*A[idx2];
                idx2--;
            }
        }
        return ret;
    }
}

// Getting the idea
// Think what happens when all numbers in the array were positive or negative.
// This problem is solved by 2 pointer approach

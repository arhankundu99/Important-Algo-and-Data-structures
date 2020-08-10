// https://leetcode.com/problems/ugly-number-ii/

class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumber = new int[n+1];
        
        uglyNumber[1] = 1;
        
        int idx1 = 1, idx2 = 1, idx3 = 1;
        
        for(int i = 2; i <= n; i++){
            uglyNumber[i] = Math.min(uglyNumber[idx1]*2, Math.min(uglyNumber[idx2]*3, uglyNumber[idx3]*5));
            
            if(uglyNumber[i] == uglyNumber[idx1]*2)idx1++;
            if(uglyNumber[i] == uglyNumber[idx2]*3)idx2++;
            if(uglyNumber[i] == uglyNumber[idx3]*5)idx3++;
            
        }
        return uglyNumber[n];
    }
}

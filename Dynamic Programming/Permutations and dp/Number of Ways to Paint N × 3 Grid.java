// https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/
// You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colours: Red, Yellow or Green while making sure that no two adjacent cells have the same colour (i.e no two cells that share vertical or horizontal sides have the same colour).
// You are given n the number of rows of the grid.
// Return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 10^9 + 7.
// see this for explanation: https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/discuss/574885/Java-O(N)-Super-Easy-DP-Solution

class Solution {
    public int numOfWays(int n) {
        int M = 1000000007;
        
        long[] aba = new long[n+1];
        long[] abc = new long[n+1];
        
        aba[1] = 6;
        abc[1] = 6;
        
        for(int i = 2; i <= n; i++){
            aba[i] = ((3*aba[i-1]) + (2*abc[i-1])) % M;
            abc[i] = ((2*aba[i-1]) + (2*abc[i-1])) % M;
        }
        return (int)((aba[n] % M + abc[n] % M) % M);
    }
}

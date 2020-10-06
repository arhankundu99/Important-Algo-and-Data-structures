// https://leetcode.com/problems/number-of-squareful-arrays/
class Solution {
    int[][] dp;
    public int numSquarefulPerms(int[] A) {
        dp = new int[A.length][1<<A.length];
        for(int i = 0; i < A.length; i++)Arrays.fill(dp[i], -1);
        return dfs(-1, 0, A);
    }
    public int dfs(int prevIdx, int mask, int[] A){
        if(mask == (1<<A.length) - 1){
            return 1;
        }
        int count = 0;
        if(prevIdx != -1 && dp[prevIdx][mask] != -1)return dp[prevIdx][mask];
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < A.length; i++){
            if((mask & (1 << i)) != 0)continue;
            
            int picked = A[i];
            if(set.contains(picked))continue;
            
            set.add(picked);
            
            if(prevIdx == -1 || isSquare(A[prevIdx] + A[i])){
                count += dfs(i, mask | (1<<i), A);
            }
        }
        if(prevIdx != -1)dp[prevIdx][mask] = count;
        return count;
    }
    public boolean isSquare(int x){
        double sqrt = Math.sqrt(x);
        return sqrt == (int)sqrt;
    }
}

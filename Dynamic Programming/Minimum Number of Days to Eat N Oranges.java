// https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/
class Solution {
    Map<Integer, Integer>dp;
    public int minDays(int n) {
        dp = new HashMap<>();
        return dfs(n);
    }
    public int dfs(int n){
        if(n < 3)return n;
        
        if(dp.containsKey(n))return dp.get(n);
        
        int min1 = dfs(n/2) + (n % 2);
        int min2 = dfs(n/3) + (n % 3);
        
        dp.put(n, 1 + Math.min(min1, min2));
        
        return 1 + Math.min(min1, min2);
    }
}

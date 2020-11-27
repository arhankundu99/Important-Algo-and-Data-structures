// https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1#
class EggDrop 
{
    static int eggDrop(int n, int k) 
	{
    	 int[][] dp = new int[n + 1][k + 1];
    	 
    	 for(int i = 0; i < n + 1; i++)Arrays.fill(dp[i], Integer.MAX_VALUE);
    	 return f(n, k, dp);
	}
	static int f(int n, int k, int[][] dp){
      //base case: if there is only one egg, we have to check each floor
      //if there is 1 floor return 1
      //if there are 0 floors return 0
	    if(k == 0 || k == 1)return k;
	    if(n == 1)return k;
	    
	    if(dp[n][k] != Integer.MAX_VALUE)return dp[n][k];
	    
	    
	    for(int i = 1; i <= k; i++){
	        //throwing an egg from ith floor
	        // 2cases
	        // case1: egg breaks, so we have n - 1 eggs and i - 1 floors to check
	        // case2: egg does not break, we have n eggs and k - 1 floors to check
	        int val = 1 + Math.max(f(n - 1, i - 1, dp), f(n, k - i, dp));
	        if(dp[n][k] > val)dp[n][k] = val;
	    }
	    return dp[n][k];
	}
}

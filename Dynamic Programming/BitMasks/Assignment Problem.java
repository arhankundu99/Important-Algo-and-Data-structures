/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/assignment-problem/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    int n = scan.nextInt();
		    int[][]a = new int[n][n];
		    
		    int[][]dp = new int[n][(int)Math.pow(2, n)+1];
		    
		    for(int i = 0; i < n; i++)Arrays.fill(dp[i], -1);
		    
		    for(int i = 0; i < n; i++)
		        for(int j = 0; j < n; j++)
		            a[i][j] = scan.nextInt();
		            
		    System.out.println(solve(a, 0, 0, n, dp));
		}
	}
	public static int solve(int[][]a, int mask, int idx, int N, int[][]dp){
	    if(mask == (1<<N) - 1)return 0;
	    if(idx == N)return Integer.MAX_VALUE;
	    
	    if(dp[idx][mask] != -1)return dp[idx][mask];
	    
	    int currCost = Integer.MAX_VALUE;
	    for(int i = 0; i < N; i++)
	    {
	        if((mask & (1<<i)) != 0)continue;
	        int x = solve(a, (mask | (1<<i)), idx+1, N, dp);
	        if(x != Integer.MAX_VALUE)currCost = Math.min(currCost, a[idx][i] + x);
	    }
	    dp[idx][mask] = currCost;
	    return currCost;
	}
}

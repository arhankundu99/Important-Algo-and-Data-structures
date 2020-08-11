// https://www.geeksforgeeks.org/bell-numbers-number-of-ways-to-partition-a-set/
// https://practice.geeksforgeeks.org/problems/bell-numbers/0
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-- > 0){
		    int n = scan.nextInt();
		    System.out.println(solve(n));
		}
	}
	public static int solve(int n){
	    int M = 1000000007;
	    int[][] dp = new int[n+1][n+1];
	    
	    dp[0][0] = 1;
	    
	    for(int i = 1; i <= n; i++){
	        for(int j = 0; j <= i; j++){
	            if(j == 0)dp[i][j] = dp[i-1][i-1];
	            else dp[i][j] = (dp[i][j-1] + dp[i-1][j-1]) % M;
	        }
	    }
	    return dp[n][0];
	}
}

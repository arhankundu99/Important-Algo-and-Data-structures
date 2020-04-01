// Compute nCr % 10e7+9

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][]dp = new int[1001][1001];
		computeTable(dp);
		int t = scan.nextInt();
		while(t-->0)
		{
		    int n=scan.nextInt();
		    int r=scan.nextInt();
		    System.out.println(dp[n][r]);
		}
	}
	public static void compute(int[][]dp)
	{
	  for(int i=0;i<1001;i++)
		{
		    dp[i][0]=1;
		    dp[i][i]=1;
		}
		for(int i=1;i<1001;i++)
		    for(int j=1;j<i&&j<1001;j++)
		        dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%1000000007;
	}
}
// Bottom up approach is used

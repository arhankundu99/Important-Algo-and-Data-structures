// https://www.geeksforgeeks.org/find-minimum-possible-size-of-array-with-given-rules-for-removal/
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] a = new int[n];
		
		for(int i = 0; i < n; i++)a[i] = scan.nextInt();
		int k = scan.nextInt();
		
		int[][] dp = new int[a.length][a.length];
		
		for(int i = 0; i < dp.length; i++)Arrays.fill(dp[i], Integer.MAX_VALUE);
		
		int ans = solve(a, 0, n-1, k, dp);
		
		System.out.println(ans);
	}
	public static int solve(int[] a, int low, int high, int k, int[][] dp){
	    if(high - low + 1 < 3)return high - low + 1;
	    
	    if(dp[low][high] != Integer.MAX_VALUE)return dp[low][high];
	    
	    int count = 1 + solve(a, low + 1, high, k, dp);
	    
	    for(int i = low + 1; i <= high; i++){
	        for(int j = i+1; j <= high; j++){
	            if(a[i] == a[low] + k && a[j] == a[low] + 2*k && solve(a, low+1, i-1, k, dp) == 0 && solve(a, i+1, j-1, k, dp) == 0){
	                count = Math.min(count, solve(a, j+1, high, k, dp));
	            }
	        }
	    }
	    dp[low][high] = count;
	    return count;
	}
}

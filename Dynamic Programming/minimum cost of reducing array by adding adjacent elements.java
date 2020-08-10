/*package whatever //do not write package name here */

import java.util.*;

class GFG {
    static int[][]dp;
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		dp = new int[n][n];
		for(int i = 0; i < n; i++)Arrays.fill(dp[i], -1);
		int[] a = new int[n];
		for(int i = 0; i < n; i++)a[i] = scan.nextInt();
		
		int[] prefixSum = new int[n];
		for(int i = 0; i < n; i++){
		    if(i == 0)prefixSum[i] = a[i];
		    else prefixSum[i] = a[i] + prefixSum[i-1];
		}
		
		System.out.println(solve(a, prefixSum, 0, n-1));
	}
	public static int solve(int[]a, int[] prefixSum, int low, int high){
	    if(low == high - 2){
	        return Math.min(2*(a[low] + a[low+1]) + a[high], 2*(a[low+1] + a[high])+a[low]);
	    }
	    if(low == high - 1){
	        return a[low] + a[high];
	    }
	    if(dp[low][high] != -1)return dp[low][high];
	    int ans = Integer.MAX_VALUE;
	    int sum = low == 0? prefixSum[high]: prefixSum[high] - prefixSum[low-1];
	    for(int i = low+1; i <= high-2; i++){
	        ans = Math.min(ans, sum + solve(a, prefixSum, low, i) + solve(a, prefixSum, i+1, high));
	    }
	    dp[low][high] = ans;
	    return ans;
	}
}

// link: https://www.geeksforgeeks.org/painters-partition-problem-set-2/?ref=rp
// Difficulty: Hard

// Approach 1: Top-down DP (Time and Space limit Exceeded)

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
		    int n = scan.nextInt();
		    int[]a = new int[n];
		    for(int i = 0; i < n; i++)a[i] = scan.nextInt();
		    int m = scan.nextInt();
		    
		    int[] sum = new int[a.length];
		    
		    sum[0] = a[0];
		    for(int i = 1; i < sum.length; i++)sum[i] = sum[i-1] + a[i];
		    
		    int[][]dp = new int[a.length][m+1];
		    
		    for(int i = 0; i < a.length; i++)Arrays.fill(dp[i], -1);
		    
		    System.out.println(topDown(a, 0, m, sum, dp));
    }
    
public static int topDown(int[]a, int idx, int k, int[]sum, int[][]dp){
	    if(k == 1)return idx == 0?sum[a.length-1]: sum[a.length-1] - sum[idx-1];
	    if(idx == a.length)return Integer.MAX_VALUE;
	    
	    if(dp[idx][k] != -1)return dp[idx][k];
	    
	    int currSum = 0, ans = Integer.MAX_VALUE;
	    
	    for(int i = idx; i < a.length; i++)
	    {
	        currSum += a[i];
	        int curr = Math.max(currSum, topDown(a, i+1, k-1, sum, dp));
	        ans = Math.min(ans, curr);
	    }
	    dp[idx][k] = ans;
	    return ans;
	}

// Approach 2: Binary Search (Accepted) Time: O(N*log(sum[0..N-1])), Space: O(N)
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
		    int n = scan.nextInt();
		    int[]a = new int[n];
		    for(int i = 0; i < n; i++)a[i] = scan.nextInt();
		    int m = scan.nextInt();
		    System.out.println(binarySearch(a, m));
		}
	}
	public static int binarySearch(int[]a, int m){
	    
	    int maxTime = getSum(a);
	    int minTime = getMinTime(a);
	    
	    int low = minTime, high = maxTime, ans = -1;
	    
	    while(low <= high)
	    {
	        int mid = low + (high-low)/2;
	        int no_of_painters = getPainters(a, mid);
	        //System.out.println(mid + " " + no_of_painters);
	        if(no_of_painters <= m)
	        {
	            ans = mid;
	            high = mid-1;
	        }
	        else low = mid+1;
	    }
	    return ans;
	}
	public static int getPainters(int[]a, int mid){
	    int currSum = 0, no_of_painters = 1;
	    for(int i = 0; i < a.length; i++)
	    {
	        currSum += a[i];
	        if(currSum > mid)
	        {
	            currSum = a[i];
	            no_of_painters++;
	        }
	    }
	    return no_of_painters;
	}
	public static int getMinTime(int[] a){
	    int time = 0;
	    for(int i = 0; i < a.length; i++)time = Math.max(time, a[i]);
	    return time;
	}
	public static int getSum(int[] a){
	    int sum = 0;
	    for(int i = 0; i < a.length; i++)sum += a[i];
	    return sum;
	}

/*
Given an array A of N positive integers. Find the minimum number of operations 
(change a number to greater or lesser than original number) 
in array so that array is strictly increasing (A[i] < A[i+1]).
Refer : https://www.geeksforgeeks.org/convert-to-strictly-increasing-integer-array-with-minimum-changes/
*/

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
	        int[] a = new int[n];
	        for(int i=0;i<n;i++)a[i] = scan.nextInt();
	        
	        int[] lis = new int[n];
	        
	        Arrays.fill(lis, 1);
	        int max = 0;
	        
	        for(int i=1;i<n;i++)
	        {
	            for(int j=0;j<i;j++)
	            {
	                if(a[i] > a[j] && (i-j) <= a[i]-a[j])
	                    lis[i] = Math.max(lis[i], lis[j]+1);
	            }
	            max = Math.max(max, lis[i]);
	        }
	        System.out.println(n-max);
	    }
	}

}

/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/count-of-subarrays/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		while(t-->0){
		    int n = scan.nextInt();
		    int k = scan.nextInt();
		    
		    int[]a = new int[n];
		    for(int i = 0; i < n; i++)a[i] = scan.nextInt();
		    
		    int ans = solve(a, k);
		    System.out.println(ans);
		}
	}
	public static int solve(int[]a, int k){
	    int idx1 = 0, idx2 = 0;
	    int count = 0;
	    while(idx2 < a.length){
	        if(a[idx2] > k){
	            //idx1 to idx2-1 contains elements which are less than k
	            int n = idx2-idx1;
	            count += (n*(n+1))/2;
	            
	            idx2++;
	            idx1 = idx2;
	        }
	        else idx2++;
	    }
	    int n = idx2-idx1;
	    count += (n*(n+1))/2;
	    
	    int total = (a.length)*(a.length+1)/2;
	    return total - count;
	}
}

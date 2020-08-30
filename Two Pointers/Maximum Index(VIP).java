// https://practice.geeksforgeeks.org/problems/maximum-index/0
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		while(t-->0){
		    int n = scan.nextInt();
		    int[] a =new int[n];
		    
		    for(int i = 0; i < n; i++)a[i] = scan.nextInt();
		    
		    int ans = solve(a);
		    System.out.println(ans);
		}
	}
	public static int solve(int[] a){
	    int[] max_right = new int[a.length];
	    
	    max_right[a.length-1] = a[a.length-1];
	    
	    for(int i = a.length-2; i >= 0; i--){
	        max_right[i] = Math.max(a[i], max_right[i+1]);
	    }
	    int[] min_left = new int[a.length];
	    
	    min_left[0] = a[0];
	    
	    for(int i = 1; i < a.length; i++){
	        min_left[i] = Math.min(a[i], min_left[i-1]);
	    }
	    
	    int ans = 0;
	    int i = 0, j = 0;
	    while(i < a.length && j < a.length){
	        if(min_left[i] <= max_right[j]){
	            ans = Math.max(ans, j-i);
	            j++;
	        }
	        else i++;
	    }
	    return ans;
	}
}

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
	            idx2++;
	            idx1 = idx2;
	        }
	        else{
	            count += idx2-idx1+1;
	            idx2++;
	        }
	    }
	    int total = (a.length)*(a.length+1)/2;
	    return total - count;
	}
}

/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/maximum-sub-string-after-at-most-k-changes/0

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
		    
		    String s = scan.next();
		    int ans = solve(s, n, k);
		    System.out.println(ans);
		}
	}
	public static int solve(String s, int n, int k){
	    int ans = 0;
	    for(int i = 0; i < 26; i++){
	        ans = Math.max(ans, solve(s, n, k, (char)(i+97)));
	        ans = Math.max(ans, solve(s, n, k, (char)(i+65)));
	    }
	    return ans;
	}
	public static int solve(String s, int n, int k, char c){
	    
	    int countC = 0; // count of different characters other than c
	    
	    int idx1 = 0;
	    int idx2 = 0;
	    
	    int maxLength = 0;
	    
	    while(idx2 < s.length()){
	        if(s.charAt(idx2) != c)countC++;
	        
	        if(countC > k){
	            if(s.charAt(idx1) != c){
	                countC--;
	                idx1++;
	            }
	            else{
	                while(s.charAt(idx1) == c)idx1++;
	                idx1++;
	                countC--;
	            }
	        }
	        maxLength = Math.max(maxLength, idx2-idx1+1);
	        idx2++;
	    }
	    return maxLength;
	}
}

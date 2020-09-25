// https://www.geeksforgeeks.org/minimize-the-maximum-difference-of-adjacent-elements-after-at-most-k-insertions/
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
	    int k = scan.nextInt();
	    
	    int[] arr = new int[n];
	    
	    for(int i = 0; i < n; i++)arr[i] = scan.nextInt();
	    
	    System.out.println(solve(arr, n, k));
	}
	public static int solve(int[] arr, int n, int k){
	    int low = 0;
	    int high = 0;
	    
	    for(int i = 1; i < arr.length; i++){
	        high = Math.max(high, Math.abs(arr[i] - arr[i-1]));
	    }
	    
	    if(high == 0)return 0;
	    
	    int ans = -1;
	    while(low <= high){
	        int mid = (low) + (high - low)/2;
	        int insertions = 0;
	        
	        for(int i = 1; i < n; i++){
	            insertions += (Math.abs(arr[i] - arr[i-1]) - 1) / mid;
	        }
	        if(insertions > k){
	            low = mid + 1;
	        }
	        else{
	            ans = mid;
	            high = mid-1;
	        }
	    }
	    return ans;
	}
}

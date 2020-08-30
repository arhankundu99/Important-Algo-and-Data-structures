// https://www.geeksforgeeks.org/minimum-cost-cut-board-squares/amp/
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		
		int[]x = new int[m];
		for(int i = 0; i < m; i++)x[i] = scan.nextInt();
		
		int[]y = new int[n];
		for(int i = 0; i < n; i++)y[i] = scan.nextInt();
		
		int ans = solve(x, y);
		
		System.out.println(ans);
	}
	public static int solve(int[] x, int[] y){
	    Arrays.sort(x);
	    Arrays.sort(y);
	    
	    for(int i = 0; i < x.length/2; i++){
	        int temp = x[i];
	        x[i] = x[x.length-i-1];
	        x[x.length-i-1] = temp;
	    }
	    
	    for(int i = 0; i < y.length/2; i++){
	        int temp = y[i];
	        y[i] = y[y.length-i-1];
	        y[y.length-i-1] = temp;
	    }
	    
	    int i = 0, j = 0, ans = 0;
	    int horizon = 1, vert = 1;
	    while(i < x.length && j < y.length){
	        if(x[i] > y[j]){
	            ans += x[i]*horizon;
	            vert++;
	            i++;
	        }
	        else{
	            ans += y[j]*vert;
	            horizon++;
	            j++;
	            
	        }
	    }
	    while(i < x.length){
	        ans += x[i]*horizon;
	        vert++;
	        i++;
	    }
	    while(j < y.length){
	        ans += y[j]*horizon;
	        vert++;
	        j++;
	    }
	    return ans;
	}
}

/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0
// https://www.geeksforgeeks.org/stock-buy-sell/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    int n = scan.nextInt();
		    int[]a = new int[n];
		    for(int i = 0; i < n; i++)a[i] = scan.nextInt();
		    List<int[]>list = new ArrayList<>();
		    int idx = 0;
		    while(idx < n){
		        //find local minimum
		        while(idx+1 < n && a[idx] >= a[idx+1])idx++;
		        
		        if(idx == n-1)break;
		        
		        int buyDay = idx;
		        
		        idx++;
		        
		        //now find local maximum
		        while(idx+1 < n && a[idx] <= a[idx+1])idx++;
		       
		        int sellDay = idx;
		        
		        list.add(new int[]{buyDay, sellDay});
		        idx++;
		    }
		    if(list.size() == 0){
		        System.out.println("No Profit");
		    }
		    else{
		        for(int[] x: list){
		            System.out.print("("+x[0]+" "+x[1]+") ");
		        }
		        System.out.println("");
		    }
		}
	}
}

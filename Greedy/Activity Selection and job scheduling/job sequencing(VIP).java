// O(N^2) solution (can give TLE)
// Refer this for O(nlogn) solution: https://www.geeksforgeeks.org/job-sequencing-using-disjoint-set-union/
// https://practice.geeksforgeeks.org/problems/job-sequencing-problem/0/
/*package whatever //do not write package name here */

// Try this: https://www.geeksforgeeks.org/job-sequencing-problem-loss-minimization/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int t = scan.nextInt();
	    while(t-->0){
	        int n = scan.nextInt();
	        pair[] pair = new pair[n];
	        for(int i = 0; i < n; i++){
	            int id = scan.nextInt();
	            int deadline = scan.nextInt();
	            int profit = scan.nextInt();
	            pair[i] = new pair(id, deadline, profit);
	        }
	        
	        Arrays.sort(pair, new Comparator<pair>(){
	           public int compare(pair a, pair b){
	               return b.profit-a.profit;
	           } 
	        });
	        
	        boolean[] vis = new boolean[n];
	        vis[Math.min(n-1,pair[0].deadline-1)] = true;
	        int profit = pair[0].profit;
	        int count = 1;
	        
	        int idx = 1;
	        while(idx < n){
	            for(int i = Math.min(pair[idx].deadline-1, n-1); i >= 0; i--){
	                if(!vis[i]){
	                    vis[i] = true;
	                    profit += pair[idx].profit;
	                    count++;
	                    break;
	                }
	            }
	            idx++;
	        }
	        System.out.println(count+" "+profit);
	    }
	}
}
class pair{
    int id, deadline, profit;
    pair(int i, int d, int p){
        this.id = i;
        this.deadline = d;
        this.profit = p;
    }
}

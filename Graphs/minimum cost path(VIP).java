/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/minimum-cost-path/0
// Dofficulty: Hard

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    int n = scan.nextInt();
		    int[][]a = new int[n][n];
		    for(int i = 0; i < n; i++)
		        for(int j = 0; j < n; j++)a[i][j] = scan.nextInt();
		    
		    List<int[]>edges = new ArrayList<>();
		    
		    for(int i = 0; i < n; i++){
		        for(int j = 0; j < n; j++){
		            int code = getCode(i, j, n);
		            
		            if(i-1 >= 0)edges.add(new int[]{getCode(i, j, n), getCode(i-1, j, n), a[i-1][j]});
		            if(i+1 < n)edges.add(new int[]{getCode(i, j, n), getCode(i+1, j, n), a[i+1][j]});
		            if(j-1 >= 0)edges.add(new int[]{getCode(i, j, n), getCode(i, j-1, n), a[i][j-1]});
		            if(j+1 < n)edges.add(new int[]{getCode(i, j, n), getCode(i, j+1, n), a[i][j+1]});
		        }
		    }
		    int[] dist = new int[n*n];
		    Arrays.fill(dist, Integer.MAX_VALUE);
		    dist[0] = 0;
		    
		    
		    for(int i = 1; i < n; i++){
		        for(int[] edge: edges){
		            int u = edge[0];
		            int v = edge[1];
		            int w = edge[2];
		            
		            if(dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + w)dist[v] = dist[u] + w;
		        }
		    }
		    int ans = dist[n*n-1]+a[0][0];
		    System.out.println(ans);
		}
	}
	public static int getCode(int r, int c, int n){
	    return r*n + c;
	}
}

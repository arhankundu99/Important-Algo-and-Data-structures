/*package whatever //do not write package name here */
// Multi source BFS is used
//https://practice.geeksforgeeks.org/problems/rotten-oranges/0

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
		    int m = scan.nextInt();
		    
		    int[][]a = new int[n][m];
		    
		    for(int i = 0; i < n; i++)
		        for(int j = 0; j < m; j++)a[i][j] = scan.nextInt();
		        
		    int[][]dist = new int[n][m];
		    
		    BFS(a, dist);
		    
		    int max = 0;
		    
		    //print(dist);
		    
		    for(int i = 0; i < dist.length; i++)
		        for(int j = 0; j < dist[0].length; j++)
		            max = Math.max(max, dist[i][j]);
		            
		    if(max == Integer.MAX_VALUE)System.out.println(-1);
		    else System.out.println(max);
		}
	}
	public static void BFS(int[][]a, int[][]dist){
	    
	    Queue<int[]>queue = new LinkedList<>();
	    
	    for(int i = 0; i < a.length; i++){
	        for(int j = 0; j < a[0].length; j++){
	            if(a[i][j] == 2){
	                queue.add(new int[]{i, j});
	                dist[i][j] = 0;
	            }
	            if(a[i][j] == 1){
	                dist[i][j] = Integer.MAX_VALUE;
	            }
	        }
	    }
	    int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	    while(queue.size() != 0){
	        int[] poll = queue.poll();
	        
	        for(int[] move: moves){
	            int r2 = poll[0] + move[0];
	            int c2 = poll[1] + move[1];
	            
	            if(isValid(r2, c2, a.length, a[0].length, a) && dist[r2][c2] > dist[poll[0]][poll[1]]+1){
	                dist[r2][c2] = dist[poll[0]][poll[1]] + 1;
	                queue.add(new int[]{r2, c2});
	            }
	        }
	    }
	}
	
	public static boolean isValid(int r, int c, int n, int m,int[][]a){
	    if(r < 0 || c < 0 || r == n || c == m || a[r][c] != 1)return false;
	    return true;
	}
	
	public static void print(int[][] dist){
	    for(int i = 0; i < dist.length; i++){
	        for(int j = 0; j < dist[0].length; j++){
	            System.out.print(dist[i][j]+" ");
	        }
	        System.out.println("");
	    }
	}
}

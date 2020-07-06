/*package whatever //do not write package name here */
https://practice.geeksforgeeks.org/problems/replace-os-with-xs/0

// note this problem can be solved using multi source BFS also
// In either case time complexity will be same

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    int n = scan.nextInt();
		    int m = scan.nextInt();
		    
		    char[][] a = new char[n][m];
		    
		    for(int i = 0; i < n; i++)
		        for(int j = 0; j < m; j++)
		            a[i][j] = scan.next().charAt(0);
		            
		    boolean[][] vis = new boolean[n][m];
		    
		    replace(a, 'O', 'F');
		    
		    for(int i = 0; i < n; i++)
		    {
		        if(a[i][0] == 'F')floodFillDFS(a, 'F', 'O', i, 0, vis);
		        if(a[i][a[0].length-1] == 'F')floodFillDFS(a, 'F', 'O', i, a[0].length-1, vis);
		    }
		    for(int i = 0; i < m; i++){
		        if(a[0][i] == 'F')floodFillDFS(a, 'F', 'O', 0, i, vis);
		        if(a[a.length-1][i] == 'F')floodFillDFS(a, 'F', 'O', a.length-1, i, vis);
		    }
		    replace(a, 'F', 'X');
		    
		    for(int i = 0; i < n; i++)
		        for(int j = 0; j < m; j++)System.out.print(a[i][j] + " ");
		        
		    System.out.println("");
		}
	}
	public static void replace(char[][]a, char source, char target){
	    for(int i = 0; i < a.length; i++)
	        for(int j = 0; j < a[0].length; j++)
	            if(a[i][j] == source)a[i][j] = target;
	}
	public static void floodFillDFS(char[][]a, char source, char target, int r, int c, boolean[][] vis){
	    if(r == a.length || c == a[0].length || r < 0 || c < 0 || a[r][c] != source || vis[r][c])return;
	    
	    a[r][c] = target;
	    
	    vis[r][c] = true;
	    
	    int[][] moves = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	    
	    for(int[] move: moves)floodFillDFS(a, source, target, r+move[0], c+move[1], vis);
	}
}

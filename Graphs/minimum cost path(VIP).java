/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/minimum-cost-path/0
// Dofficulty: Hard

/*package whatever //do not write package name here */

//using dijkstra
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    int n = scan.nextInt();
		    int[][] a = new int[n][n];
		    for(int i = 0; i < n; i++)
		        for(int j = 0; j < n; j++)
		            a[i][j] = scan.nextInt();
		    
		    List<int[]>edges = new ArrayList<>();
		    
		    int[][] cost = new int[n][n];
		    for(int i = 0; i < n; i++)
		        Arrays.fill(cost[i], Integer.MAX_VALUE);
		    
		    cost[0][0] = a[0][0];
		    
		    PriorityQueue<int[]>queue = new PriorityQueue<>(new Comparator<int[]>(){
		        public int compare(int[] a, int[] b){
		            return cost[a[0]][a[1]] - cost[b[0]][b[1]];
		        }   
		    });
		    
		    queue.add(new int[]{0, 0});
		    boolean[][] vis = new boolean[n][n];
		    
		    int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		    while(queue.size() != 0){
		        int[] poll = queue.poll();
		        int r = poll[0];
		        int c = poll[1];
		        
		        if(vis[r][c])continue;
		        vis[r][c] = true;
		        
		        for(int[] move: moves){
		            int r2 = r + move[0];
		            int c2 = c + move[1];
		            
		            if(isValid(r2, c2, n)){
		                if(cost[r2][c2] > cost[r][c] + a[r2][c2]){
		                    cost[r2][c2] = cost[r][c] + a[r2][c2];
		                    queue.add(new int[]{r2, c2});
		                }
		            }
		        }
		    }
		    
		    System.out.println(cost[n-1][n-1]);
		}
	}
	public static boolean isValid(int r, int c, int n){
	    if(r < 0 || c < 0 || r == n || c == n)return false;
	    return true;
	}
}

//using bellman-ford
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
		    int[][] a = new int[n][n];
		    for(int i = 0; i < n; i++)
		        for(int j = 0; j < n; j++)
		            a[i][j] = scan.nextInt();
		    
		    List<int[]>edges = new ArrayList<>();
		    
		    int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		    
		    for(int i = 0; i < n; i++){
		        for(int j = 0; j < n; j++){
		            for(int[] move: moves){
		                int r2 = i + move[0];
		                int c2 = j + move[1];
		                
		                if(isValid(r2, c2, n))edges.add(new int[]{i, j, r2, c2, a[r2][c2]});
		            }
		        }
		    }
		    
		    int[][] cost = new int[n][n];
		    for(int i = 0; i < n; i++)
		        Arrays.fill(cost[i], Integer.MAX_VALUE);
		    
		    cost[0][0] = a[0][0];
		    
		    for(int i = 0; i < n; i++){
		        for(int[] edge: edges){
		            int uR = edge[0];
		            int uC = edge[1];
		            
		            int vR = edge[2];
		            int vC = edge[3];
		            
		            int w = edge[4];
		            
		            if(cost[uR][uC] != Integer.MAX_VALUE && cost[vR][vC] > cost[uR][uC] + w){
		                cost[vR][vC] = cost[uR][uC] + w;
		            }
		        }
		    }
		    System.out.println(cost[n-1][n-1]);
		}
	}
	public static boolean isValid(int r, int c, int n){
	    if(r < 0 || c < 0 || r == n || c == n)return false;
	    return true;
	}
}

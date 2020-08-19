/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int[][] mat = new int[n][m];
		for(int i = 0; i < n; i++)
		    for(int j = 0; j < m; j++)mat[i][j] = scan.nextInt();
		    
		int ax = scan.nextInt();
		int ay = scan.nextInt();
		
		List<int[]>list = new ArrayList<>();
		
		for(int i = 0; i < n; i++){
		    for(int j = 0; j < m; j++){
		        if(mat[i][j] == 2)list.add(new int[]{i, j});
		    }
		}
		
		int num_coins = list.size();
		
		int[][][] dist = new int[n][m][num_coins];
		
		for(int i = 0; i < n; i++)
		    for(int j = 0; j < m; j++)Arrays.fill(dist[i][j], 99999999);
		    
		for(int i = 0; i < num_coins; i++)computeDistance(mat, dist, list.get(i)[0], list.get(i)[1], i);
		
		int ans = Integer.MAX_VALUE;
		int[][] dp = new int[num_coins][1<<num_coins];
		
		for(int i = 0; i < num_coins; i++)Arrays.fill(dp[i], -1);
		
		for(int i = 0; i < num_coins; i++)ans = Math.min(ans, dist[0][0][i] + solve(mat, dist, ax, ay, 1<<i, num_coins, i, list, dp));
		ans = ans == Integer.MIN_VALUE?-1:ans;
		System.out.println(ans);
	}
	
	
	public static int solve(int[][] mat, int[][][] dist, int ar, int ac, int mask, int num_coins, int idx, List<int[]>list, int[][] dp){
	    if(mask == (1<<num_coins)-1)return dist[ar][ac][idx];
	    
	    if(dp[idx][mask] != -1)return dp[idx][mask];
	    
	    int ans = Integer.MAX_VALUE;
	    int r = list.get(idx)[0], c = list.get(idx)[1];
	    
	    for(int i = 0; i < num_coins; i++){
	        if((mask & (1<<i)) != 0)continue;
	        
	        ans = Math.min(ans, dist[r][c][i] + solve(mat, dist, ar, ac, mask | (1<<i), num_coins, i, list, dp));
	    }
	    
	    dp[mask][idx] = ans;
	    return ans;
	}
	
	
	public static void computeDistance(int[][] mat, int[][][] dist, int r, int c, int idx){
	    
	    Queue<int[]>queue = new LinkedList<>();
	    
	    queue.add(new int[]{r, c});
	    
	    dist[r][c][idx] = 0;
	    int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	    
	    while(queue.size() != 0){
	        int[] poll = queue.poll();
	        
	        for(int[] move: moves){
	            int r2 = poll[0] + move[0];
	            int c2 = poll[1] + move[1];
	            
	            if(isValid(mat, r2, c2) && dist[r2][c2][idx] > dist[poll[0]][poll[1]][idx] + 1){
	                dist[r2][c2][idx] = dist[poll[0]][poll[1]][idx] + 1;
	                queue.add(new int[]{r2, c2});
	            }
	        }
	    }
	}
	public static boolean isValid(int[][] mat, int r, int c){
	    if(r < 0 || r == mat.length || c < 0 || c == mat[0].length || mat[r][c] == 1)return false;
	    return true;
	}
}

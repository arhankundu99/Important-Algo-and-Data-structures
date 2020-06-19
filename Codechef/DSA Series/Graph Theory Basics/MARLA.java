/* package codechef; // don't place package name! */
// problem link: https://www.codechef.com/LRNDSA08/problems/MARLA
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int[][]grid = new int[n][m];
		
		for(int i=0;i<n;i++)
		    for(int j=0;j<m;j++)grid[i][j] = scan.nextInt();
		    
		boolean[][]vis = new boolean[n][m];
		int maxCount = 0, leastVal = Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<m;j++)
		    {
		        if(vis[i][j])continue;
		        int val = grid[i][j];
		        
		        int count = dfs(grid, i, j, vis, grid[i][j]);
		        
		        if(maxCount < count)
		        {
		            maxCount = count;
		            leastVal = val;
		        }
		        else if(maxCount == count)leastVal = Math.min(leastVal, val);
		    }
		}
		System.out.println(leastVal+" "+maxCount);
	}
	public static int dfs(int[][]grid, int i, int j, boolean[][]vis, int val)
	{
	    if(i == grid.length || i < 0 || j < 0 || j == grid[0].length || vis[i][j] || grid[i][j] != val)return 0;
	    vis[i][j] = true;
	    return 1 + dfs(grid, i-1, j, vis, val) + dfs(grid, i+1, j, vis, val) + dfs(grid, i, j-1, vis, val) + dfs(grid, i, j+1, vis, val);
	}
}

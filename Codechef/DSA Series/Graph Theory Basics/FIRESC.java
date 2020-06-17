/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static long ans1 = 0, chainLength = 0;
    static int M = 1000000007;
    static long ans2 = 1;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
		    int n = scan.nextInt();
		    int m = scan.nextInt();
		    
		    ans1 = 0;
		    ans2 = 1;
		    
		    Map<Integer, Set<Integer>>map = new HashMap<>();
		    
		    for(int i=1 ;i<=n;i++)map.put(i, new HashSet<>());
		    
		    for(int i=0;i<m;i++)
		    {
		        int f1 = scan.nextInt();
		        int f2 = scan.nextInt();
		        
		        map.get(f1).add(f2);
		        map.get(f2).add(f1);
		    }
		    boolean[] vis = new boolean[n+1];
		    
		    for(int key : map.keySet())
		    {
		        if(vis[key])continue;
		        chainLength = 0;
		        dfs(key, map, vis);
		            
		        ans1 = (ans1 + 1) % M;
		        ans2 = (ans2 * chainLength) % M;
		        
		    }
		    System.out.println(ans1+" "+ans2);
		}
	}
	public static void dfs(int idx, Map<Integer, Set<Integer>>map, boolean[] vis)
	{
	    if(vis[idx])return;
	    vis[idx] = true;
	    chainLength++;
	    Set<Integer>set = map.get(idx);
	    for(int i : set)dfs(i, map, vis);
	}
}

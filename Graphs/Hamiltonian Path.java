// https://practice.geeksforgeeks.org/problems/hamiltonian-path/0
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    int V = scan.nextInt();
		    int E = scan.nextInt();
		    boolean flag = false;
		    
		    Map<Integer, Set<Integer>>map = new HashMap<>();
		    
		    for(int i = 0; i < E; i++){
		        int u = scan.nextInt();
		        int v = scan.nextInt();
		        if(!map.containsKey(u))map.put(u, new HashSet<>());
		        map.get(u).add(v);
		        if(!map.containsKey(v))map.put(v, new HashSet<>());
		        map.get(v).add(u);
		    }
		    
		    Set<Integer>vis = new HashSet<>();
		    for(int key: map.keySet()){
		        int count = dfs(key, vis, map);
		        if(count == V)
		        {
		            flag = true;
		            break;
		        }
		        //System.out.println(key+" "+count);
		    }
		    if(flag)System.out.println(1);
		    else System.out.println(0);
		}
	}
	public static int dfs(int idx, Set<Integer>vis, Map<Integer, Set<Integer>>map){
	    if(vis.contains(idx))return Integer.MAX_VALUE;
	    vis.add(idx);
	    int count = 1;
	    
	    if(!map.containsKey(idx))
	    {
	        vis.remove(idx);
	        return 1;
	    }
	    
	    for(int v: map.get(idx)){
	        int res = dfs(v, vis, map);
	        if(res != Integer.MAX_VALUE)count = Math.max(count, 1+res);
	    }
	    vis.remove(idx);
	    return count;
	}
}

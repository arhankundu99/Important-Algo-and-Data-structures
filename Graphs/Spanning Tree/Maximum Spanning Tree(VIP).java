// Find maximum cost to make the graph spanning.
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		while(t-->0){
		    int n = scan.nextInt();
		    int p = scan.nextInt();
		    
		    int[][] edges = new int[p][3];
		    
		    for(int i = 0; i < p; i++){
		        int u = scan.nextInt();
		        int v = scan.nextInt();
		        int w = -scan.nextInt();
		        
		        edges[i][0] = u;
		        edges[i][1] = v;
		        edges[i][2] = w;
		    }
		    
		    int ans = -mst(edges);
		    System.out.println(ans);
		}
	}
	public static int mst(int[][] edges){
	    uf uf = new uf(edges.length+1);
	    
	    Arrays.sort(edges, new Comparator<int[]>(){
	        public int compare(int[] a, int[] b){
	            return a[2] - b[2];
	        }
	    });
	    
	    int cost = 0;
	    
	    for(int[] edge: edges){
	        int u = edge[0];
	        int v = edge[1];
	        int w = edge[2];
	        
	        int uRep = uf.find(u);
	        int vRep = uf.find(v);
	        
	        if(uRep == vRep)continue;
	        
	        cost += w;
	        uf.union(u, v);
	    }
	    return cost;
	}
}
class uf{
    int[] parent;
    int[] rank;
    
    uf(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++)parent[i] = i;
    }
    int find(int x){
        if(x == parent[x])return x;
        return parent[x] = find(parent[x]);
    }
    void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y)return;
        
        if(rank[x] > rank[y])parent[y] = x;
        else if(rank[x] < rank[y])parent[x] = y;
        else{
            parent[x] = y;
            rank[y]++;
        }
    }
}

// Reference: https://leetcode.com/discuss/interview-question/202553/Traveling-is-Fun/
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int thresold = scan.nextInt();
		int q = scan.nextInt();
		
		int[] ori = new int[q];
		
		
		int[] des = new int[q];
		
		dsu dsu = new dsu(n+1);
		
		for(int i = 0; i < q; i++)ori[i] = scan.nextInt();
		
		q = scan.nextInt();
		for(int i = 0; i < q; i++)des[i] = scan.nextInt();
		
		Map<Integer, Integer>map = new HashMap<>();
		for(int i = 1; i*i <= n; i++){
		    for(int j = 1; j <= n; j++){
		        if(i > thresold && j % i == 0){
		            if(!map.containsKey(i))map.put(i, j);
		            else dsu.union(j, map.get(i));
		        }
		        if(j % i == 0 && j/i > thresold){
		            if(!map.containsKey(j/i))map.put(j/i, j);
		            else dsu.union(j, map.get(j/i));
		        }
		    }
		}
		int[] ans = new int[q];
		for(int i = 0; i < q; i++){
		    int x = dsu.find(ori[i]);
		    int y = dsu.find(des[i]);
		    
		    if(x == y)ans[i] = 1;
		}
		for(int i = 0; i < q; i++)System.out.print(ans[i]+" ");
		System.out.println("");
	}
}
class dsu{
    int[] parent;
    int[] rank;
    
    dsu(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++)parent[i] = i;
    }
    int find(int x){
        if(parent[x] == x)return x;
        return parent[x] = find(parent[x]);
    }
    void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y)return;
        
        if(rank[x] > rank[y]){
            parent[y] = x;
            return;
        }
        if(rank[x] < rank[y]){
            parent[x] = y;
            return;
        }
        parent[x] = y;
        rank[y]++;
    }
}

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int thresold = scan.nextInt();
		int q = scan.nextInt();
		
		int[] ori = new int[q];
		
		
		int[] des = new int[q];
		
		dsu dsu = new dsu(n+1);
		
		for(int i = 0; i < q; i++)ori[i] = scan.nextInt();
		
		q = scan.nextInt();
		for(int i = 0; i < q; i++)des[i] = scan.nextInt();
		
		for(int i = thresold + 1; i <= n; i++){
		    for(int j = 2*i; j <= n; j++){
		        dsu.union(j, j-i);
		    }
		}
		int[] ans = new int[q];
		for(int i = 0; i < q; i++){
		    int x = dsu.find(ori[i]);
		    int y = dsu.find(des[i]);
		    
		    if(x == y)ans[i] = 1;
		}
		for(int i = 0; i < q; i++)System.out.print(ans[i]+" ");
		System.out.println("");
	}
}
class dsu{
    int[] parent;
    int[] rank;
    
    dsu(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++)parent[i] = i;
    }
    int find(int x){
        if(parent[x] == x)return x;
        return parent[x] = find(parent[x]);
    }
    void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y)return;
        
        if(rank[x] > rank[y]){
            parent[y] = x;
            return;
        }
        if(rank[x] < rank[y]){
            parent[x] = y;
            return;
        }
        parent[x] = y;
        rank[y]++;
    }
}

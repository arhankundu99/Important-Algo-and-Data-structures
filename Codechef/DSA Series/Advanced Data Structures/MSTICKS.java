/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] b = new int[N];
		
		for(int i = 0; i < N; i++)b[i] = scan.nextInt();
		
		segmentTree maxTree = new segmentTree(N, true);
		segmentTree minTree = new segmentTree(N, false);
		
        maxTree.build(0, N-1, b, 0);
		minTree.build(0, N-1, b, 0);
		
		int Q = scan.nextInt();
		
		while(Q -- > 0)
		{
		    int l = scan.nextInt();
		    int r = scan.nextInt();
		    
		    int min_in_LR = minTree.search(0, N-1, l, r, 0);
		    
		    int max_in_LR = maxTree.search(0, N-1, l, r, 0);
		    
		    int max_in_r1 = maxTree.search(0, N-1, 0, l-1, 0);
		    
		    int max_in_r2 = maxTree.search(0, N-1, r+1, N-1, 0);
		    
		    
		    double ans = min_in_LR + Math.max(max_in_r1, Math.max(max_in_r2, (max_in_LR - min_in_LR)/2.0));

		    System.out.printf("%.1f\n",ans);
		}
		
		
	}
}
class segmentTree
{
    int[] tree;
    boolean flag;
    segmentTree(int size, boolean flag)
    {
        tree = new int[4*size];
        this.flag = flag;
    }
    void build(int low, int high, int[] b, int idx)
    {
        if(low == high)
        {
            tree[idx] = b[low];
            return;
        }
        int mid = (low+high)/2;
        
        build(low, mid, b, 2*idx+1);
        build(mid+1, high, b, 2*idx+2);
        
        if(flag)tree[idx] = Math.max(tree[2*idx+1], tree[2*idx+2]);
        else tree[idx] = Math.min(tree[2*idx+1], tree[2*idx+2]);

    }
    int search(int low, int high, int L, int R, int idx)
    {
        if(low >= L && high <= R)return tree[idx];
        if(L > high || R < low || L > R)return -1;
        
        int mid = (low+high)/2;
        
        int x = search(low, mid, L, R, 2*idx+1);
        int y = search(mid+1, high, L, R, 2*idx+2);
        
        if(flag)return Math.max(x, y);
        
        if(x == -1)return y;
        if(y == -1)return x;
        
        return Math.min(x, y);
    }
    void print()
    {
        for(int i=0;i<tree.length;i++)System.out.print(tree[i]+" ");
        System.out.println("");
    }
}

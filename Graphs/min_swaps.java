// calculate the minimum number of swaps to sort an array
// Also selection sort sorts the array using minimum number of swaps

import java.util.*;
class MinSwaps{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		  while(t-->0)
      {
			  int n = sc.nextInt();
			  int[] a=new int[n];
			  for(int i = 0; i<n ; i++)
				  a[i]=sc.nextInt();
			  GfG g=new GfG();
			  System.out.println(g.minSwaps(a,n));
		  }
	  }
}


/*Complete the function*/
class GfG
{
	public static int minSwaps(int[] A, int N)
	{
	    int swaps = 0;
        pair[] pair = new pair[A.length];
        for(int i=0;i<A.length;i++)
            pair[i] = new pair(A[i], i);
        
        Arrays.sort(pair, new Comparator<pair>(){
           public int compare(pair a, pair b){return a.val-b.val;} 
        });
	    
	    Map<Integer, Integer>map = new HashMap<>();
	    
	    for(int i=0;i<A.length;i++)map.put(pair[i].idx, i);
	    
	    boolean[] vis = new boolean[A.length];
	    
	    for(int i=0;i<A.length;i++)
	    {
	        if(vis[i] || map.get(i) == i)continue;
	        
	        vis[i] = true;
	        
	        int cycle_size = 1;
	        
	        int idx = i;
	        
	        while(map.get(idx) != i)
	        {
	            idx = map.get(idx);
	            vis[idx] = true;
	            cycle_size++;
	        }
	        swaps += (cycle_size - 1);
	    }
	    return swaps;
	}
}
class pair
{
    int val, idx;
    pair(int v, int i)
    {
        val = v;
        idx = i;
    }
}

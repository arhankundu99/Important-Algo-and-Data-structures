Difficulty: CakeWalk
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
		int t = scan.nextInt();
		while(t-->0)
		{
		    int n = scan.nextInt();
		    int q = scan.nextInt();
		    String s = scan.next();
		    
		    int max = 0;
		    Map<Character, Integer>map = new HashMap<>();
		    Map<Integer, Integer>fmap = new HashMap<>();
		    
		    for(int i=0;i<n;i++)
		    {
		        if(map.containsKey(s.charAt(i)))
		            map.put(s.charAt(i), map.get(s.charAt(i))+1);
		        else map.put(s.charAt(i), 1);
		        
		        int key = map.get(s.charAt(i));
		        if(fmap.containsKey(key))
		            fmap.put(key,fmap.get(key)+1); 
		        else fmap.put(key, 1);
		        
		        max = Math.max(max, map.get(s.charAt(i)));
		    }
		    
		    int[] sum = new int[max+1];
		    for(int i=1;i<sum.length;i++)
		    {
		        if(fmap.containsKey(i))
		            sum[i] = sum[i-1]+fmap.get(i);
		        else sum[i] = sum[i-1];
		    }
		 
		    while(q-->0)
		    {
		        int c = scan.scanInt();
		        if(c >= max)System.out.println(0);
		        else System.out.println(n - sum[c]);
		    }
		}
		print.close();
	}
}

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
		    int[] a = new int[n];
		    for(int i=0;i<n;i++)a[i] = scan.nextInt();
		    
		    int curr = Integer.MAX_VALUE;
		    
		    long ans = 0;
		    
		    for(int i=0;i<n;i++)
		    {
		        curr = Math.min(curr, a[i]);
		        ans += curr;
		    }
		    System.out.println(ans);
		}
	}
}

// Idea: The maximum tokens in ith box = min(capacity of ith box, min capacity of all boxes before ith box)

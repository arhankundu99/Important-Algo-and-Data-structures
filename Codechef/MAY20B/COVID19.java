Difficulty level : Cakewalk
Idea : Greedy

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
		    int[]x = new int[n];
		    for(int i=0;i<n;i++)x[i] = scan.nextInt();
		    
		    int min = 9, max = 1, curr = 1;
		    
		    for(int i=1;i<n;i++)
		    {
		        if(x[i] - x[i-1] <= 2)curr++;
		        else 
		        {
		            max = Math.max(max, curr);
		            min = Math.min(min, curr);
		            curr = 1;
		        }
		    }
		    max = Math.max(max, curr);
		    min = Math.min(min, curr);
		    
		    System.out.println(min+" "+max);
		}
	}
}

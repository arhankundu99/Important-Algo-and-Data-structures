/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		while(t-->0)
		{
		    int ret=0;
		    int n=scan.nextInt();
		    while(n-->0)
		    {
		        int s=scan.nextInt();
		        int p=scan.nextInt();
		        int v=scan.nextInt();
		        
		        ret=Math.max(ret,((p/(s+1))*v));
		        
		    }
		    System.out.println(ret);
		}
	}
}

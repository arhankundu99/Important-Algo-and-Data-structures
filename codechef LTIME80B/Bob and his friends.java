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
		    long n=scan.nextLong();
		    long a=scan.nextLong();
		    long b=scan.nextLong();
		    long c=scan.nextLong();
		    
		    long ret=9223372036854775807L;
		    while(n-->0)
		    {
		        int f=scan.nextInt();
		        ret=Math.min(ret,Math.abs(a-f)+c+Math.abs(f-b));
		    }
		    System.out.println(ret);
		}
	}
}

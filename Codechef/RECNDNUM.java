/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static int M = 1000000007;
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
		    int n = scan.nextInt();
		    int k = scan.nextInt();
		    
		    int ans = 0;
		    
		    if(n==0)
		    {
		        System.out.println(mult(k, k-1));
		        continue;
		    }
		    int firstTime = mult(n, n);
		    
		    k = k-1;
		    
		    int noOfTerms = k/2;
		    
		    int secondTerm = add(mult(noOfTerms,noOfTerms), noOfTerms);
		    int firstTerm = 0;
		    if(k%2 == 0)firstTerm = mult(k/2, 2*n);
		    else firstTerm = mult((k/2)+1, 2*n);
		    ans = add(firstTerm, secondTerm);
		    ans = add(ans, firstTime);
		    
		    System.out.println(ans);
		}
	}
	public static int add(int a, int b)
	{
	    return (int)((0L+a+b)%M);
	}
	public static int mult(int a, int b)
	{
	    return (int)((1L*a*b)%M);
	}
}

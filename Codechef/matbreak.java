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
	        int a = scan.nextInt();
	        
	        int prod=1,ans=0;
	        for(int i=0;i<n;i++)
	        {
	            int curr = pow(mult(a, prod), 2 * i + 1);
	  	    ans = add(ans,curr);
	 	    prod = mult(prod, curr);
	        }
	        System.out.println(ans);
	    }
	}
	public static int add(int a,int b){return (int)((0L+a+b)%M);}
	public static int mult(int a, int b){return (int)((a*1L*b)%M);}
	public static int pow(int a,int b)
    	{
        	if(b==0)return 1;
        	int p = pow(a,b/2);
        	if(b%2==0)return mult(p,p);
        	return mult(mult(p,p),a);
    	}
    
}

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
		    int k = scan.nextInt();
		    boolean found = false;
		    
		    int[]a = new int[n];
		    
		    for(int i=0;i<n;i++)a[i] = scan.nextInt();
		    
		    if(n==1)
		    {
		        if(a[0]==-1)a[0] = k;
		        System.out.println("YES");
		        System.out.println(a[0]);
		    }
		    if(k==2)solveK2(a);
		    else
		    {
		        int curr = 1;
		        for(int i=0;i<n;i++)
		        {
		            if(a[i] != -1)continue;
		            if(i==0)
		            {
		                if(curr==a[1])
		                {
		                    curr = (curr+1)%k;
		                    if(curr == 0)curr++;
		                }
		                a[0] = curr;
		            }
		            else if(i == n-1)
		            {
		                if(curr==a[n-2])
		                {
		                    curr = (curr+1)%k;
		                    if(curr == 0)curr++;
		                }
		                a[n-1] = curr;
		            }
		            else
		            {
		                while(curr == a[i-1] || curr == a[i+1])
		                {
		                    curr = ((curr+1)%k);
		                    if(curr == 0)curr++;
		                }
		                a[i] = curr;
		            }
		        }
		        
		        for(int i=0;i<n-1;i++)
		        {
		            if(a[i] == a[i+1])
		            {
		                System.out.println("NO");
		                found = true;
		                break;
		            }
		        }
		        
		        if(!found)
		        {
		            System.out.println("YES");
		            for(int i=0;i<n;i++)System.out.print(a[i]+" ");
		            System.out.println("");
		        }
		    }
		}
	}
	public static void solveK2(int[]a)
	{
	    int p = -1;
	    int n = a.length;
	    while(p+1 < n && a[p+1] == -1)p++;
	    if(p == n-1)a[p] = 1;
	    else if(p>=0)a[p] = 3-a[p+1];
	    while(--p>=0)a[p] = 3-a[p+1];
	        
	        for(int i = 1; i< n; i++){
	            if(a[i] == -1)a[i] = 3-a[i-1];
	        }
	        boolean possible = true;
	        for(int i = 1; i< n; i++)possible &= a[i] != a[i-1];
	        if(possible){
	            System.out.println("YES");
	            for(int i:a)System.out.print(i+" ");System.out.println("");
	        }else System.out.println("NO");
	        return;
	}
}

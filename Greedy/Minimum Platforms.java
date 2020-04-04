//Given arrival and departure times of all trains that reach a railway station. 
//Your task is to find the minimum number of platforms required for the railway station so that no train waits.

import java.util.*;
import java.lang.*;

class Solution {
	public static void main (String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		while(t-->0)
		{
		    int n=scan.nextInt();
		    int[]a=new int[n];
		    int[]d=new int[n];
		    for(int i=0;i<n;i++)a[i]=scan.nextInt();
		    for(int i=0;i<n;i++)d[i]=scan.nextInt();
		    
		    Arrays.sort(a);
		    Arrays.sort(d);
		    
		    int idx1=0, idx2=0, currCount=0, maxCount=0;

		    while(idx1<a.length)
		    {
		        if(a[idx1]<=d[idx2])
		        {
		            currCount++;
		            maxCount=Math.max(maxCount,currCount);
		            idx1++;
		        }
		        else
		        {
		            currCount--;
		            idx2++;
		        }
		    }
		    System.out.println(maxCount);
		}
	}
}

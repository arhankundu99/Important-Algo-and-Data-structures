/* package codechef; // don't place package name! */
// finding number of inversions in array

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static long ans = 0;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int []a = new int[n];
		    
		for(int i=0;i<n;i++)
		  a[i] = scan.nextInt();
		        
		 mergeSort(a,0,a.length-1);
		 

		 System.out.println(ans);
	}
	public static void mergeSort(int[]a, int l, int r)
	{
	    if(l<r)
	    {
	        int mid = (l+r)/2;
	        mergeSort(a, l, mid);
	        mergeSort(a, mid+1, r);
	        
	        merge(a,l,mid,r);
	    }
	}
	public static void merge(int[]a, int l, int mid, int r)
	{
	    int[]left = new int[mid-l+1];
	    int[]right = new int[r-mid];
	    
	    int idx = l;
	    for(int i=0;i<left.length;i++)left[i] = a[idx++];
	    for(int i=0;i<right.length;i++)right[i] = a[idx++];
	    
	    int idx1=0, idx2=0;
	    idx = l;
	    
	    while(idx1<left.length && idx2<right.length)
	    {
	        if(left[idx1]<=right[idx2])a[idx++] = left[idx1++];
	        else 
	        {
	            a[idx++] = right[idx2++];
	            ans += (mid+1)-(idx1+l);
	        }
	    }
	    while(idx1!=left.length)a[idx++] = left[idx1++];
	    while(idx2!=right.length)a[idx++] = right[idx2++];
	}
}

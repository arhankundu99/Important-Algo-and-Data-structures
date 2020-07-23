// Merlin is obsessed with buckets of water. He has total of n buckets of water. Each bucket has some litres of water in it. 
// We can either remove the bucket or remove few litres of water from the bucket.
// We have to ensure that each bucket has equal amount of water by removing minimum litres of water. Compute the minimum amount of water

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[]buckets = new int[n];
		for(int i = 0; i < n; i++)buckets[i] = scan.nextInt();
		
		System.out.println(equalize(buckets));
	}
	public static int equalize(int[] buckets){
	    Arrays.sort(buckets);
	    int[]left = new int[buckets.length];
	    left[0] = buckets[0];
	    for(int i = 1; i < buckets.length; i++)left[i] = left[i-1] + buckets[i];
	    
	    int[]right = new int[buckets.length];
	    right[buckets.length-1] = buckets[buckets.length-1];
	    for(int i = buckets.length-2; i >= 0; i--)right[i] = buckets[i] + right[i+1];
	    
	    int ans = Integer.MAX_VALUE;
	    for(int i = 0; i < buckets.length; i++){
	        int curr = 0;
	        if(i > 0)curr += left[i-1];
	        if(i+1 < buckets.length)curr += (right[i+1]) - ((buckets.length-i-1)*buckets[i]);
	        ans = Math.min(ans, curr);
	    }
	    return ans;
	}
}

/*package whatever //do not write package name here */
//https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
//O(N^2) solution

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    int n = scan.nextInt();
		    int[]a = new int[n];
		    for(int i = 0; i < n; i++){
		        a[i] = scan.nextInt();
		        a[i] *= a[i];
		    }
		    boolean flag = false;
		    for(int i = 0; i < n; i++){
		        Set<Integer>set = new HashSet<>();
		        for(int j = i+1; j < n; j++){
		            if(set.contains(a[i] + a[j]) || set.contains(Math.abs(a[i]-a[j])))
		            {
		                flag = true;
		                break;
		            }
		            set.add(a[j]);
		        }
		        if(flag)break;
		    }
		    if(flag)System.out.println("Yes");
		    else System.out.println("No");
		}
	}
}
//O(max*max) Solution

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    int max = 0;
		    int n = scan.nextInt();
		    int[]a = new int[n];
		    boolean flag = false;
		    Map<Integer, Integer>map = new HashMap<>();
		    for(int i = 0; i < n; i++){
		        a[i] = scan.nextInt();
		        max = Math.max(max, a[i]);
		        if(map.containsKey(a[i]))map.put(a[i], map.get(a[i])+1);
		        else map.put(a[i], 1);
		    }
		    for(int i = 1; i <= max; i++){
		        if(!map.containsKey(i))continue;
		        for(int j = 1; j <= max; j++){
		            if(!map.containsKey(j) || ((i==j) && map.get(i) == 1))continue;
		            
		            int sqr = (i*i) + (j*j);
		            int sqrt = (int)Math.sqrt(sqr);
		            if(sqrt*sqrt != sqr)continue;
		            if(map.containsKey(sqrt))
		            {
		                flag = true;
		                break;
		            }
		        }
		        if(flag)break;
		    }
		    if(flag)System.out.println("Yes");
		    else System.out.println("No");
		}
	}
}

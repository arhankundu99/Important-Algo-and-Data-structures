// brute force
// find min a[j] such that (a[i] | a[j]) + 1 is 2^x and i != j
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
	    int[] arr = new int[n];
	    for(int i = 0; i < n; i++)arr[i] = scan.nextInt();
	    
	    int[] res = new int[n];
	    
		
		Map<Integer, Integer> map = new HashMap<>();
		
		Map<Integer, Integer>resMap = new HashMap<>();
		
		for(int i = 0; i < n; i++){
		    if(!map.containsKey(arr[i]))map.put(arr[i], i);
		}
		
		for(int i = 0; i < arr.length; i++){
		    int minValue = Integer.MAX_VALUE;
		    for(int key: map.keySet()){
		        if(map.get(key) == i)continue;
		        int or = arr[i] | key;
		        
		        if((or & (or + 1)) == 0){
		            minValue = Math.min(minValue, key);
		        }
		    }
		    minValue = minValue == Integer.MAX_VALUE?-1: minValue;
		    res[i] = minValue;
		    
		    if(minValue != -1)resMap.put(arr[i], minValue);
		}
		for(int i = 0; i < arr.length; i++){
		    if(res[i] == -1 && resMap.containsKey(arr[i]))res[i] = resMap.get(arr[i]);
		}
		for(int i = 0; i < arr.length; i++)System.out.print(res[i]+" ");
		System.out.println("");
	}
}

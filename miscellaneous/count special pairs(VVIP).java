count the number of pairs (i, j) such that (a[i] + a[j])% b = c and (a[i] * a[j])%b = d and i < j

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++)a[i] = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int d = scan.nextInt();
		Map<Integer, Integer>map = new HashMap<>();
		map.put(a[0] % b, 1);
		int count = 0;
		for(int i = 1; i < a.length; i++){
		    int z = (c - a[i] + b) % b;
		    
		    if((a[i] * z) % b == d && map.containsKey(z))count += map.get(z);
		    
		    if(map.containsKey(a[i] % b))map.put(a[i] % b, map.get(a[i] % b)+1);
		    else map.put(a[i] % b, 1);
		}
		System.out.println(count);
	}
}

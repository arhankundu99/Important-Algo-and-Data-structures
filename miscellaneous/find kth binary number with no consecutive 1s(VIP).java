// 1, 10, 100, 101, 1000, 1001, 1010.....find kth binary number.

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<Integer, Integer>map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		
		int key = 4;
		int maxKey = 3;
		while(true){
		    map.put(key, map.get(key-1)+map.get(key-2));
		    if(map.get(key) >= 100000000)break;
		    key++;
		    maxKey = Math.max(key, maxKey);
		}
		int t = scan.nextInt();
		while(t-->0){
		    int k = scan.nextInt();
		    
		    long ans = 0;
		
		    
		    while(k!= 0){
		        //System.out.println(idx);

		        for(int i = 1; i <= maxKey; i++){
		            if(map.get(i) == k){
		                ans += (long)Math.pow(2, i-1);
		                System.out.println(Long.toBinaryString(ans));
		                k=0;
		                break;
		            }
		            if(map.get(i) > k){
		                ans += (long)Math.pow(2, i-2);
		                k = k - (map.get(i-1));
		                break;
		            }
		        }
		    }
	    }
	}
}

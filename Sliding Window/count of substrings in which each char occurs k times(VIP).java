// Reference: https://codeforces.com/blog/entry/80868
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String s = scan.next();
		int k = scan.nextInt();
		
		System.out.println(solve(s, k));
	}
	public static long solve(String s, int k){
	    int countD = count(s);
	    long count = 0;
	    while(countD * k > s.length())countD--;
	    
	    for(int i = countD; i >= 1; i--){
	        int windowSize = i * k;
	        
	        int p1 = 0, p2 = 0;
	        Map<Character, Integer> map = new HashMap<>();
	        
	        boolean flag = true;
	        while(p2 < windowSize){
	            if(!map.containsKey(s.charAt(p2)))map.put(s.charAt(p2), 1);
	            else map.put(s.charAt(p2), map.get(s.charAt(p2))+1);
	            p2++;
	        }
	        
	        int countKFreq = 0;

	        for(char key: map.keySet()){
	           if(map.get(key) == k)countKFreq++;
	        }
	        if(countKFreq == i){
	            System.out.println(s.substring(0, p2));
	            count++;
	        }
	        
	        while(p2 < s.length()){
	            char remove = s.charAt(p1);
	            char add = s.charAt(p2);
	            
	            p1++;
	            p2++;
	            
	            if(remove == add){
	                if(map.get(add) == k && countKFreq == i){
	                    count++;
	                    System.out.println(s.substring(p1, p2));
	                }
	                continue;
	            }
	            else{
	                if(map.get(remove) == k+1)countKFreq++;
	                if(map.get(remove) == k)countKFreq--;
	                if(map.get(remove) == 1)map.remove(remove);
	                else map.put(remove, map.get(remove)-1);
	                
	                if(!map.containsKey(add))map.put(add, 1);
	                else map.put(add, map.get(add)+1);
	                
	                if(map.get(add) == k+1)countKFreq--;
	                if(map.get(add) == k)countKFreq++;
	            }

	            if(countKFreq == i){
	                count++;
	                System.out.println(s.substring(p1, p2));
	            }
	        }
	    }
	    return count;
	}
	public static int count(String s){
	    Set<Character>set = new HashSet<>();
	    for(int i = 0; i < s.length(); i++)set.add(s.charAt(i));
	    return set.size();
	}
}

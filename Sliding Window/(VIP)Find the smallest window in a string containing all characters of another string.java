/*package whatever //do not write package name here */
//https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
//Given two strings string1 and string2, the task is to find the smallest substring in string1 containing all characters of string2 efficiently.
// very important

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    String s = scan.next();
		    String text = scan.next();
		    
		    System.out.println(solve(s, text));
		}
	}
	public static String solve(String s, String t){
	    if(t.length() > s.length())return "-1";
	    
	    int minLength = Integer.MAX_VALUE;
	    
	    Map<Character, Integer>map = new HashMap<>();
	    int count = t.length();
	    
	    for(int i = 0; i < t.length(); i++){
	        if(!map.containsKey(t.charAt(i)))map.put(t.charAt(i), 1);
	        else map.put(t.charAt(i), map.get(t.charAt(i))+1);
	    }
	    int j = 0;
	    int idx1 = -1, idx2 = -1;
	    for(int i = 0; i < s.length(); i++){
	        if(map.containsKey(s.charAt(i))){
	            if(map.get(s.charAt(i)) > 0)count--;
	            map.put(s.charAt(i), map.get(s.charAt(i))-1);
	            if(count == 0){
	                //now we increase j until we reach smaller substring
	                while(true){
	                    if(map.containsKey(s.charAt(j))){
	                        if(map.get(s.charAt(j)) == 0)break;
	                        map.put(s.charAt(j), map.get(s.charAt(j))+1);
	                    }
	                    j++;
	                }
	                int length = i - j + 1;
	                if(length < minLength){
	                    minLength = length;
	                    idx1 = j;
	                    idx2 = i;
	                }
	            }
	        }
	    }
	    if(idx1 == -1)return "-1";
	    return s.substring(idx1, idx2+1);
	}
}

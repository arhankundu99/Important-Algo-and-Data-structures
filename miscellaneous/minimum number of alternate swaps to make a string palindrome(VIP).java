// https://www.codechef.com/submit/ENCD12
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int ans = solve(s);
		System.out.println(ans);
	}
	public static int solve(String s){
	    
	    int count = 0; // minimum adjacent swaps
	    
	    StringBuilder sb = new StringBuilder();
	    sb.append(s);
	    
	    int dist = Integer.MAX_VALUE; //minimum distance of character with odd length from the middle
	    char oddC = '0'; // character which has odd length
	    
	    if(sb.length() % 2 != 0){
	        
	        //there should be only one charater which odd length
	        int[] freq = new int[26];
	        for(int i = 0; i < sb.length(); i++)freq[sb.charAt(i)-97]++;
	        
	        int oddCount = 0;
	        
	        for(int i = 0; i < 26; i++){
	            if(freq[i] % 2 != 0){
	                oddCount++;
	                oddC = (char)(i+97);
	            }
	        }
	        if(oddCount > 1)return -1;
	        
	        
	        for(int i = 0; i < sb.length(); i++){
	            if(sb.charAt(i) == oddC){
	                if(dist > Math.abs(sb.length()/2 - i)){
	                    dist = Math.abs(sb.length()/2 - i);
	                }
	            }
	        }
	        for(int i = 0; i < sb.length(); i++){
	            if(sb.charAt(i) == oddC){
	                sb.deleteCharAt(i);
	                break;
	            }
	        }
	    }
	    if(dist == Integer.MAX_VALUE)dist = 0; //means the given string is of even length
	    char[] c = sb.toString().toCharArray();
	    
	    for(int i = 0; i < c.length/2; i++){
	        int left = i;
	        int right = c.length - i - 1;
	        
	        while(left <= right){
	            if(c[left] == c[right])break;
	            right--;
	        }
	        if(left == right)return -1;
	        
	        for(int j = right; j < c.length - i - 1; j++){
	            char temp = c[j];
	            c[j] = c[j+1];
	            c[j+1] = temp;
	            
	            count++;
	        }
	    }
	    
	    
	    sb = new StringBuilder();
	    sb.append(String.valueOf(c));
	    if(s.length() % 2 != 0)sb.insert(s.length()/2, oddC); //insert the character which has odd length
	    System.out.println(sb);
	    
	    count += dist;
	    return count;
	}
}

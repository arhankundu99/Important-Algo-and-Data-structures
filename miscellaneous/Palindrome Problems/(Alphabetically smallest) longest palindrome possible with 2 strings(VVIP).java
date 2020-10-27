// Given 2 strings s1 and s2, find all palindromes that can be formed with the letters of each string. 
// from those palindromes select one from each set such that when combined and rearranged produces the largest palindrome possible. 
// if there are more than 1 palindrome, choose the alphabetically smallest of them

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		
		s1 = getPalindrome(s1);
		s2 = getPalindrome(s2);
		
		String ans = getPalindrome(s1+s2);
		System.out.println(ans);
	}
	public static String getPalindrome(String s){
	    StringBuilder sb = new StringBuilder();
	    
	    int[] count = new int[26];
	    pair[] pair = new pair[26];
	    
	    for(int i = 0; i < s.length(); i++)count[s.charAt(i) - 'a']++;
	    
	    for(int i = 0; i < count.length; i++)pair[i] = new pair((char)(i+'a'), count[i]);
	    
	    Arrays.sort(pair, new Comparator<pair>(){
	       public int compare(pair a, pair b){
	           return a.character - b.character;
	       } 
	    });
	    
	    boolean oddLength = false; //denotes whether the length of the palindrome is odd or not
	    for(int j = 0; j < 26; j++){
	        int freq = pair[j].freq;
	        char c = pair[j].character;
	        if(freq == 0)continue;
	        
	        if(sb.length() == 0){
	            for(int i = 0; i < freq; i++)sb.append(c);
	            if(freq % 2 != 0)oddLength = true;
	        }
	        
	        else{
	            //if current length of the palindrome is odd, that means we can add only even number of characters
	            if(oddLength){
	                if(freq % 2 != 0)freq--;
	                
	                for(int i = 0; i < freq; i++){
	                    int midIdx = sb.length()/2;
	                    if(i >= freq/2)midIdx++;
	                    sb.insert(midIdx, c);
	                }
	            }
	            //if current length of the palindrome is even, we can add any number of characters
	            else{
	                if(freq % 2 != 0)oddLength = true;
	                for(int i = 0; i < freq; i++){
	                    int midIdx = sb.length()/2;
	                    sb.insert(sb.length()/2, c);
	                }
	            }
	        }
	    }
	    return sb.toString();
	}
}
class pair{
    char character;
    int freq;
    pair(char c, int f){
        character = c;
        freq = f;
    }    
}

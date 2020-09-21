#### nth palindrome of k digits:
half num = `(n-1) + 10^(k) if k is odd` <br/>
         = `(n-1) + 10^(k-1) otherwise` <br/>
   
no of 1 digit palindromes = 9 <br>
no of 2 digit palindromes = 9 <br>
no of 3 digit palindromes = 90 <br>
no of 4 digit palindromes = 90 <br>
no of 5 digit palindromes = 900 <br>
and so on....

<https://www.geeksforgeeks.org/find-nth-even-length-palindromic-number-formed-using-digits-x-and-y/>
```java
assuming x < y
n = log(N/2 + 1)
if(n == (int)n)ans = yyyy....(2 * n) times
else{
     int x = N - ((2 power (n + 1)) - 2)
     now find xth palindrome of 2 power (n+1) digits
     
     String s = write x in binary and then replace 0 with x and 1 with y
     ans = s + mirror(s)
}
```

```java
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		System.out.println(solve(N, x, y));
	}
	public static String solve(int N, int x, int y){
	    StringBuilder sb = new StringBuilder();
	    double n = Math.log(N/2 + 1)/Math.log(2);
	    
	    if(n == (int)n){
	        for(int i = 1; i <= 2*n; i++)sb.append(y);
	        return sb.toString();
	    }
	    
	    N -= 2*((1<<(int)n) - 1) + 1;
	    
	    sb.append(Integer.toBinaryString(N));
	    
	    int paddingLength = (int)(n+1) - sb.length();
	    
	    for(int i = 0; i < paddingLength; i++)sb.insert(0, 0);
	    
	    char[] c = sb.toString().toCharArray();
	    
	    for(int i = 0; i < c.length; i++)
	        if(c[i] == '0')c[i] = (char)(x+48);
	        else c[i] = (char)(y+48);
	        
	    sb = new StringBuilder(String.valueOf(c));
	    return sb.toString() + sb.reverse().toString();
	}
}
```
link: https://www.geeksforgeeks.org/find-nth-even-length-palindromic-number-formed-using-digits-x-and-y/> <br/>
Palindrome problems: divide the problem into half and try to solve it

#### Base conversion on java
Integer.toString( 
            Integer.parseInt(number, sBase), 
            dBase);
            
<https://www.geeksforgeeks.org/search-an-element-in-an-array-where-difference-between-adjacent-elements-is-1/>
<https://www.geeksforgeeks.org/check-if-an-array-is-sorted-and-rotated-using-binary-search/?ref=leftbar-rightbar>
<https://www.geeksforgeeks.org/logarithm-tricks-for-competitive-programming/?ref=leftbar-rightbar>

<https://www.geeksforgeeks.org/minimum-lines-cover-points/>

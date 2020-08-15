#### nth palindrome of k digits:
half num = (n-1) + 10^(k) if k is odd <br>
         = (n-1) + 10^(k-1) otherwise <br>
   
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
if(n == (int)n)ans = yyyy....(2 power n) times
else{
     int x = N - ((2 power (n + 1)) - 2)
     now find xth palindrome of 2 power (n+1) digits
     
     String s = write x in binary and then replace 0 with x and 1 with y
     ans = s + mirror(s)
}
```
Palindrome problems: divide the problem into half and try to solve it

#### Base conversion on java
Integer.toString( 
            Integer.parseInt(number, sBase), 
            dBase);
            
<https://www.geeksforgeeks.org/search-an-element-in-an-array-where-difference-between-adjacent-elements-is-1/>
<https://www.geeksforgeeks.org/check-if-an-array-is-sorted-and-rotated-using-binary-search/?ref=leftbar-rightbar>
<https://www.geeksforgeeks.org/logarithm-tricks-for-competitive-programming/?ref=leftbar-rightbar>

<https://www.geeksforgeeks.org/minimum-lines-cover-points/>

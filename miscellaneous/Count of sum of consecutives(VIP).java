/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/count-of-sum-of-consecutives/0
// https://www.geeksforgeeks.org/count-ways-express-number-sum-consecutive-numbers/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    int n = scan.nextInt();
		    int count = 0;
		    for(int p = 2; p*(p+1) <= 2*n; p++){
		        double a1 = (((2D*n)/p)-p+1)/2;
		        if(a1 == (int)a1)count++;
		    }
		    System.out.println(count);
		}
	}
}

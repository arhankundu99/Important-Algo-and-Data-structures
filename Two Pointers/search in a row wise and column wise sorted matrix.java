// https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/#:~:text=Given%20an%20n%20x%20n%20matrix%20and,is%20sorted%20in%20increasing%20order.

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    boolean flag = false;
		    int r = scan.nextInt();
		    int c = scan.nextInt();
		    int[][] a = new int[r][c];
		    for(int i = 0; i < r; i++)
		        for(int j = 0; j < c; j++)a[i][j] = scan.nextInt();
		    int val = scan.nextInt();
		    int i = 0, j = c-1;
		    while(i < r && j >= 0){
		        if(val == a[i][j]){
		            flag = true;
		            break;
		        }
		        else if(val > a[i][j]){
		            i++;
		        }
		        else j--;
		    }
		    if(flag)System.out.println(1);
		    else System.out.println(0);
		}
	}
}

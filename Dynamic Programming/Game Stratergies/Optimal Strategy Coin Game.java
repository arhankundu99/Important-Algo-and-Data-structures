//You are given an array A of size N. The array contains integers and is of even length.
//The elements of the array represent N coin of values V1, V2, ....Vn. You play against an opponent in an alternating way.
//In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, 
//and receives the value of the coin.
//You need to determine the maximum possible amouint of money you can win if you go first.

import java.util.*;
import java.lang.*;

class solution {
    static int[][]dp;
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
		    int n = scan.nextInt();
		    int[]coins = new int[n];
		    for(int i=0;i<n;i++)coins[i] = scan.nextInt();
		    dp = new int[coins.length][coins.length];
		    System.out.println(dfs(0,coins.length-1,coins));
		}
	}
	public static int dfs(int left, int right, int[]coins){
	    if(left==right)return coins[left];
	    if(left==right-1)return Math.max(coins[left], coins[right]);
	    
	    if(dp[left][right]!=0)return dp[left][right];
	    
	    int choice1Profit = coins[left]+Math.min(dfs(left+2,right,coins),dfs(left+1,right-1,coins));
	    int choice2Profit = coins[right]+Math.min(dfs(left+1,right-1,coins),dfs(left,right-2,coins));
	    
	    dp[left][right] = Math.max(choice1Profit, choice2Profit);
	    
	    return dp[left][right];
	}
}

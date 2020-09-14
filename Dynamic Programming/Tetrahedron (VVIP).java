// https://codeforces.com/problemset/problem/166/E
// for explanation: https://github.com/MathProgrammer/CodeForces/blob/master/Explanations/Explanations%20-%204/Tetrahedron%20-%20Explanation.txt

import java.util.*;
public class Solution{
    static int M = 1000000007;
    static long[][] dp;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        int flag = 1;
        long count_to_b = 1;
        long count_to_acd = 0;
        
        long prev_count_to_b = 1;
        long prev_count_to_acd = 0;
        
        for(int i = 1; i <= n; i++){
            count_to_b = (3*(prev_count_to_acd)) % M;
            count_to_acd = ((2*(prev_count_to_acd)) + prev_count_to_b) % M;
            
            prev_count_to_b = count_to_b;
            prev_count_to_acd = count_to_acd;
        }
        
        System.out.println((int)count_to_b);
    }
    public static long solve(int n, int flag){
        // base case
        if(n == 0){
            if(flag == 1)return 1;
            return 0;
        }
        if(dp[n][flag] != -1)return dp[n][flag];
        if(flag == 1)return dp[n][flag] = (3 * solve(n-1, 0)) % M;
        return dp[n][flag] = (2 * solve(n-1, 0) + solve(n-1, 1)) % M;
    }
}

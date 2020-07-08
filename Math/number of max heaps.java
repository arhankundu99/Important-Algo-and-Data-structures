//https://www.interviewbit.com/problems/ways-to-form-max-heap/
public class Solution {
    int M = 1000000007;
    public int solve(int A) {
        int[][]dp = new int[A+1][A+1];
        for(int i = 0; i <= A; i++)Arrays.fill(dp[i], -1);
        combination(dp);
        return T(A, dp);
        
    }
    public int T(int A, int[][]dp){
        if(A == 0 || A == 1)return 1;
        int l = getLeftCount(A);
        long ans = mult(dp[A-1][l], T(l, dp));
        ans = mult(ans, T(A-1-l, dp));
        return (int)ans;
    }
    public int getLeftCount(int A){
        if(A == 0 || A == 1)return 1;
        int height = (int)(Math.log(A)/Math.log(2));
        
        int part1 = (int)Math.pow(2, height-1)-1;
        
        int part2 = 0;
        if(A >= (int)Math.pow(2, height)-1 + (int)Math.pow(2, height-1))part2 = part1+1;

        else part2 = A - (int)(Math.pow(2, height)-1);
        
        return part1 + part2;
    }
    public void combination(int[][]dp){
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for(int i = 2; i < dp.length; i++){
            for(int j = 1; j < i; j++){
                dp[i][j] = add(dp[i-1][j-1], dp[i-1][j]);
            }
        }
    }
    public int mult(long A, long B){
        return (int)((A*B) % M);
    }
    public int add(long A, long B){
        return (int)((A+B)%M);
    }
}

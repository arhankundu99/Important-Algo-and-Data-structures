https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

class Solution {
    int[][]dp;
    public int minInsertions(String s) {
        dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
            for(int j=i;j<s.length();j++)dp[i][j]=-1;
        return minInsertions(s,0,s.length()-1);
    }
    public int minInsertions(String s,int lowIdx,int highIdx)
    {
        if(lowIdx>=highIdx)return 0;
        if(dp[lowIdx][highIdx]!=-1)return dp[lowIdx][highIdx];
        
        int x=1+Math.min(minInsertions(s,lowIdx+1,highIdx),minInsertions(s,lowIdx,highIdx-1));
        if(s.charAt(lowIdx)==s.charAt(highIdx))
            dp[lowIdx][highIdx]=Math.min(x,minInsertions(s,lowIdx+1,highIdx-1));
        else dp[lowIdx][highIdx]=x;
        return dp[lowIdx][highIdx];
    }
}

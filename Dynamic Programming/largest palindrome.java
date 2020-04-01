//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

class Solution {
    public String longestPalindrome(String s) {
        int[][]dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)dp[i][i]=1;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))dp[i][i+1]=1;
        }
        for(int i=s.length()-3;i>=0;i--)
        {
            for(int j=i+2;j<s.length();j++)
            {
                if(s.charAt(i)==s.charAt(j))dp[i][j]=dp[i+1][j-1];
            }
        }
        int startIndex=0,endIndex=1,maxLength=1;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+1;j<s.length();j++)
            {
                if(dp[i][j]==1&&maxLength<j-i+1)
                {
                    maxLength=j-i+1;
                    startIndex=i;
                    endIndex=j+1;
                }
            }
        }
        if(s.equals(""))return "";
        return s.substring(startIndex,endIndex);
    }
}

//Time complexity O(n^2) Space Complexity O(n^2)
//But we can solve this in constant space by expanding around the centre

class Solution {
    int maxL=0,idx1=0,idx2=0;
    public String longestPalindrome(String s) {
        if(s.length()==0)return s;
        for(int i=0;i<s.length();i++)
        {
            expandAround(s,i,i);
            expandAround(s,i,i+1);
        }
        return s.substring(idx1,idx2+1);
    }
    public void expandAround(String s,int left,int right)
    {
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        if(maxL<right-left+1)
        {
            maxL=right-left+1;
            idx1=left+1;
            idx2=right-1;
        }
    }
}

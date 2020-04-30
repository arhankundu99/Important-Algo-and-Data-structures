// leetcode problem 1415
/*
A happy string is a string that:

consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

*/

class Solution {
    int count = 0;
    String ans = "";
    public String getHappyString(int n, int k) {
        dfs(n, k, '0', new StringBuilder());
        return ans;
    }
    public void dfs(int n, int k, char prev, StringBuilder res)
    {
        if(n==0)
        {
            count++;
            if(count == k)ans = String.valueOf(res);
            return;
        }
        int length = res.length();
        for(int i=97;i<100;i++)
        {
            if(prev != (char)i)
            {
                dfs(n-1, k, (char)i,res.append((char)i));  //choose a
                res.delete(length, res.length());  //backtrack
                if(!ans.isEmpty())return;
            }
        }
    }
}

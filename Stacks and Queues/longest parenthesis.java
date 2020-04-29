// leetcode prob 32

//Given a string containing just the characters '(' and ')', 
//find the length of the longest valid (well-formed) parentheses substring.

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        int result=0;
        st.push(-1);
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')st.push(i);
            else
            {
                st.pop();
                if(st.isEmpty())st.push(i);
                else result=Math.max(result,i-st.peek());
                
            }
        }
        return result;
    }
}

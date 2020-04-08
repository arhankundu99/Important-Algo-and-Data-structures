// leetcode problem 20
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==')')
            {
                if(st.isEmpty()||st.peek()!='(')return false;
                else st.pop();
            }
            else if(s.charAt(i)==']')
            {
                if(st.isEmpty()||st.peek()!='[')return false;
                else st.pop();
            }
            else if(s.charAt(i)=='}')
            {
                if(st.isEmpty()||st.peek()!='{')return false;
                else st.pop();
            }
            else st.push(s.charAt(i));
        }
        if(st.isEmpty())return true;
        return false;
    }
}

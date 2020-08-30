// https://leetcode.com/problems/scramble-string/
class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())return false;
        if(s1.equals(s2))return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        boolean flag = true;
        
        for(int i = 0; i < c1.length; i++)
            if(c1[i] != c2[i]){
                flag = false;
                break;
            }
        if(!flag)return false;
        
        int n = s1.length();
        
        for(int i = 1; i < n; i++){
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, n), s2.substring(i, n)))return true;
            
            if(isScramble(s1.substring(0, i), s2.substring(n-i, n)) && isScramble(s1.substring(i, n), s2.substring(0, n-i)))return true;
        }
        return false;
    }
}

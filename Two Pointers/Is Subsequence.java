https://leetcode.com/problems/is-subsequence/
class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIdx = 0, tIdx = 0;
        
        while(tIdx < t.length()){
            if(sIdx == s.length())break;
            if(s.charAt(sIdx) == t.charAt(tIdx)){
                sIdx++;
                tIdx++;
            }
            else tIdx++;
        }
        return sIdx == s.length();
    }
}

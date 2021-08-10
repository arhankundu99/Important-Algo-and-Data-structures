// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3876/
class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int[] count0 = new int[s.length()];
        int[] count1 = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            if(i == 0)count0[i] = s.charAt(i) == '0'? 1: 0;
            else count0[i] = s.charAt(i) == '0'? 1 + count0[i - 1]: count0[i - 1];
        }
        
        for(int i = s.length() - 1; i >= 0; i--){
            if(i == s.length() - 1)count1[i] = s.charAt(i) == '1'? 1: 0;
            else count1[i] = s.charAt(i) == '1'? 1 + count1[i + 1]: count1[i + 1];
        }
        
        int minFlips = Math.min(s.length() - count0[s.length() - 1], s.length() - count1[0]);
        
        for(int i = 0; i < s.length() - 1; i++){
            int flips = (i + 1) - count0[i] + (s.length() - (i + 1) - count1[i + 1]);
            minFlips = Math.min(flips, minFlips);
        }
        return minFlips;
    }
}

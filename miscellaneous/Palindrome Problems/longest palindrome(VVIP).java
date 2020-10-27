// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3423/

class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[52];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 97)count[s.charAt(i)-'a']++;
            else count[s.charAt(i)-'A'+26]++;
        }
        int ans = 0;
        boolean odd_length = false;
        
        for(int i = 0; i < count.length; i++){
            if(count[i] % 2 != 0){
                if(!odd_length){
                    ans += count[i];
                    odd_length = true;
                }
                else ans += count[i] - 1;
            }
            else ans += count[i];
        }
        return ans;
    }
}

// https://leetcode.com/problems/find-longest-awesome-substring/
class Solution {
    public int longestAwesome(String s) {
        int[] dp = new int[1025];
        Arrays.fill(dp, -1);
        int maxLength = 0, xor = 0;
        
        for(int i = 0; i < s.length(); i++){
            int val = s.charAt(i) - 48;
            
            xor ^= (1<<val);
            
            //even length palindrome
            if(xor == 0)maxLength = i + 1;
            else if(dp[xor] != -1)maxLength = Math.max(maxLength, i - dp[xor]);
            
            //odd length palindrome
            if((xor & (xor-1)) == 0)maxLength = i + 1;
            for(int j = 0; j <= 9; j++){
                int tempXor = xor ^ (1<<j); //flip the bit
                if(dp[tempXor] != -1)maxLength = Math.max(maxLength, i - dp[tempXor]);
            }
            
            if(xor != 0 && dp[xor] == -1)dp[xor] = i;
            
        }
        return maxLength;
    }
    
}

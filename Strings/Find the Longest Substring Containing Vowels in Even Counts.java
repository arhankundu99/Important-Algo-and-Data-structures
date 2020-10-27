// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('a', 1);
        map.put('e', 2);
        map.put('i', 4);
        map.put('o', 8);
        map.put('u', 16);
        
        int[] dp = new int[33];
        Arrays.fill(dp, -1);
        
        int maxLength = 0;
        int xor = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(map.containsKey(c))xor ^= map.get(c);
            
            if(xor == 0)maxLength = i + 1;
            if(dp[xor] != -1)maxLength = Math.max(maxLength, i - dp[xor]);
            
            if(xor != 0 && dp[xor] == -1)dp[xor] = i;
        }
        return maxLength;
    }
}

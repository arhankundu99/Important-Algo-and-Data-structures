//return the minimum cost to change word1 to word2 using only 3 operation (Insertion, deletion and replacement)
class Solution {
    int[][]dp;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++)Arrays.fill(dp[i], -1);
        return dfs(word1, word2, 0, 0);
    }
    public int dfs(String word1, String word2, int idx1, int idx2){
        
        if(idx1 == word1.length())return word2.length()-idx2;
        if(idx2 == word2.length())return word1.length()-idx1;
        
        if(dp[idx1][idx2] != -1)return dp[idx1][idx2];
        
        if(word1.charAt(idx1) != word2.charAt(idx2))
        {
            int insertionCost = 1+dfs(word1, word2, idx1, idx2+1);
            int deletionCost = 1+dfs(word1, word2, idx1+1, idx2);
            int replacementCost = 1+dfs(word1, word2, idx1+1, idx2+1);
            
            dp[idx1][idx2] = Math.min(insertionCost, Math.min(deletionCost, replacementCost));
        }
        else dp[idx1][idx2] = dfs(word1, word2, idx1+1, idx2+1);
        
        return dp[idx1][idx2];
    }
}

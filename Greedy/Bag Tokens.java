// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3506/
class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        
        int i = 0, j = tokens.length-1, maxScore = 0, score = 0;
        while(i <= j){
            if(P >= tokens[i]){
                P -= tokens[i];
                score++;
                maxScore = Math.max(maxScore, score);
                i++;
            }
            else if(score >= 1){
                P += tokens[j];
                score--;
                j--;
            }
            else j--;
        }
        return maxScore;
    }
}

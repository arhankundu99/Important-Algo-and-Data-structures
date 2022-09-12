// https://leetcode.com/problems/bag-of-tokens/
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0, maxScore = 0;
        
        int i = 0, j = tokens.length - 1;
        
        while(i <= j){
            if(power >= tokens[i]){
                power -= tokens[i];
                score++;
                maxScore = Math.max(maxScore, score);
                i++;
            }
            else{
                if(score == 0)break;
                score--;
                power += tokens[j];
                j--;
            }
        }
        
        return maxScore;
    }
}

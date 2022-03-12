// https://leetcode.com/problems/best-sightseeing-pair/
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int maxScore = Integer.MIN_VALUE;
        
        int idx = 0;
        
        for(int i = 1; i < values.length; i++){
            maxScore = Math.max(maxScore, values[idx] + idx + values[i] - i);
            
            if(values[idx] + idx < values[i] + i)idx = i;
        }
        
        return maxScore;
    }
}

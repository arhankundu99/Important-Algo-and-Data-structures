// Problem 135 
// https://leetcode.com/problems/candy/
class Solution {
    public int candy(int[] ratings) {
        
        //base case
        if(ratings.length == 1)return 1;
        
        //candies[i] denotes the number of candies given to ith child
        int[] candies = new int[ratings.length];
        
        //All children must have atleast 1 candy
        Arrays.fill(candies, 1);
        
        int minCandies = 0;
        
        int[] LISReverse = new int[ratings.length];
        buildLISReverse(LISReverse, ratings);
        
        if(ratings[0] > ratings[1])candies[0] = LISReverse[0];
        
        minCandies += candies[0];
        
        for(int i = 1; i < ratings.length - 1; i++){
            
            int prevRating = ratings[i - 1];
            int currRating = ratings[i];
            int nextRating = ratings[i + 1];
            
            //four cases
            
            //second case
            if(prevRating >= currRating && nextRating < currRating){
                candies[i] = LISReverse[i]; 
            }
            
            //third case
            else if(prevRating < currRating && nextRating >= currRating){
                candies[i] = candies[i - 1] + 1;
            }
            
            //fourth case
            else if(prevRating < currRating && nextRating < currRating){
                candies[i] = Math.max(candies[i - 1] + 1, LISReverse[i]);
            }

            
            minCandies += candies[i];
        }
        
        if(ratings[ratings.length - 1] > ratings[ratings.length - 2])
            candies[ratings.length - 1] = candies[ratings.length - 2] + 1;
        
        minCandies += candies[ratings.length - 1];
        
        return minCandies;
    }
    
    public void buildLISReverse(int[] LISReverse, int[] ratings){
        Arrays.fill(LISReverse, 1);
        
        for(int i = LISReverse.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1])
                LISReverse[i] = LISReverse[i + 1] + 1;
        } 
    }

}

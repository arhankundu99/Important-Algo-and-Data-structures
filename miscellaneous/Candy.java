// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3793/
class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 1)return 1;
        
        int[] dslr = new int[ratings.length]; //dslr[i] is decreasing subsequence length in reverse direction
        Arrays.fill(dslr, 1);
        
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1])dslr[i] = dslr[i + 1] + 1;
        }
        
        int[] count = new int[ratings.length];
        
        if(ratings[0] <= ratings[1])count[0] = 1;
        else count[0] = dslr[0];
        
        for(int i = 1; i < ratings.length - 1; i++){
            if(ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1])
                count[i] = 1;
            else if(ratings[i] > ratings[i - 1] && ratings[i] <= ratings[i + 1])
                count[i] = count[i - 1] + 1;
            else if(ratings[i] <= ratings[i - 1] && ratings[i] > ratings[i + 1])
                count[i] = dslr[i];
            else count[i] = Math.max(count[i - 1] + 1, dslr[i]);
        }  
        if(ratings[ratings.length - 1] > ratings[ratings.length - 2])
            count[ratings.length - 1] = count[ratings.length - 2] + 1;
        else count[ratings.length - 1] = 1;
        
        int total = 0;
        for(int i = 0; i < ratings.length; i++)total += count[i];
        return total;
    }
}

public class Solution {
    public int candy(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }
}

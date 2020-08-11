// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3420/

class Solution {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length+1];
        
        for(int i = 0; i < citations.length; i++)count[Math.min(citations[i], citations.length)]++;
        
        int total = 0;
        for(int i = citations.length; i >= 0; i--){
            total += count[i];
            //total stores the number of papers with >= i citations
            
            if(total >= i)return i;
        }
        return -1;
    }
}

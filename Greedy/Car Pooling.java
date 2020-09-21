// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3467/
// similar to minimum number of platforms
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        pair[] pairA = new pair[trips.length];
        pair[] pairB = new pair[trips.length];
        
        for(int i = 0; i < trips.length; i++){
            pairA[i] = new pair(trips[i][1], trips[i][0]);
            pairB[i] = new pair(trips[i][2], trips[i][0]);
        }
        
        sort(pairA);
        sort(pairB);
        
        int i = 0, j = 0, currCap = 0;
        
        while(i < trips.length && j < trips.length){
            if(pairA[i].time < pairB[j].time){
                currCap += pairA[i].count;
                i++;
            }
            else{
                currCap -= pairB[j].count;
                j++;
            }
            if(currCap > capacity)return false;
        }
        return true;
    }
    public void sort(pair[] pair){
        Arrays.sort(pair, new Comparator<pair>(){
           public int compare(pair a, pair b){
               return a.time - b.time;
           } 
        });
    }
}
class pair{
    int time, count;
    pair(int time, int count){
        this.time = time;
        this.count = count;
    }
}

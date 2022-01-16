// https://leetcode.com/problems/maximize-distance-to-closest-person/
class Solution {
    public int maxDistToClosest(int[] seats) {
        int leftIdx = 0, rightIdx = 0, maxDist = 0;
        
        while(rightIdx < seats.length){
            
            while(leftIdx < seats.length && seats[leftIdx] == 1)leftIdx++;
            
            rightIdx = leftIdx;
            while(rightIdx < seats.length && seats[rightIdx] == 0)rightIdx++;
            
            int freeSeats = rightIdx - leftIdx;
            
            maxDist = Math.max(maxDist, (freeSeats + 1) / 2);
            
            leftIdx = rightIdx;
        }
        
        int leftMost1Idx = -1, rightMost1Idx = -1;
        
        //find the leftMost 1 in the seats
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 1){
                leftMost1Idx = i;
                break;
            }
        }
        
        //find the rightMost 1 in the seats
        for(int i = seats.length - 1; i >= 0; i--){
            if(seats[i] == 1){
                rightMost1Idx = i;
                break;
            }
        }
        
        maxDist = Math.max(maxDist, leftMost1Idx);
        maxDist = Math.max(maxDist, seats.length - rightMost1Idx - 1);
        
        return maxDist;
    }
}

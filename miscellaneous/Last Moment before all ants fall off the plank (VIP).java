// https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/?envType=daily-question&envId=2023-11-04

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment = 0;
        for(int i = 0; i < left.length; i++){
            lastMoment = Math.max(lastMoment, left[i]);
        }

        for(int i = 0; i < right.length; i++){
            lastMoment = Math.max(lastMoment, n - right[i]);
        }

        return lastMoment;
    }
}

// https://leetcode.com/discuss/interview-question/4947290/google-phone-maximum-total-score

// Given a sequence of stones with non-negative integers, 
// calculate the maximum possible score starting from the beginning to end. 
// You can jump any number of positions from each position. 
// The score is calculated as the destination stone_value * number_of_jump_positions. 
// Essentially the first value in the array doesn't matter as you always jump from beginning and only the destination stone value is considered in the score computation. 
// You need to solve it in less than O(n^2) time.


class Solution {
    public int getMaxScore(int[] stones) {
        // [3, 5, 2, 8, 1]
        int[] maxIndexInRight = new int[stones.length];
        maxIndexInRight[stones.length - 1] = -1; // [0, 0, 0, 0, -1]

        int max = stones[stones.length - 1]; // 1
        int maxElementIndex = stones.length - 1; // 4

        int score = 0;
        for (int i = stones.length - 2; i >= 0; i--) {
            maxIndexInRight[i] = maxElementIndex; // [3, 3, 3, 4, -1]
            if (max < stones[i]) {
                max = stones[i]; // 8
                maxElementIndex = i; // 3
            }
        }

        int currIdx = 0;
        int score = 0;
        while (currIdx != stones.length - 1) {
            int nextIdx = maxIndexInRight[currIdx]; // 4
            score += stones[nextIdx] * (nextIdx - currIdx); // 8 * 3 + 1
            currIdx = nextIdx; // 4
        }
        return score; // 25
    }
}
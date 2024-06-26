// https://leetcode.com/problems/predict-the-winner/
// Note: In getScoreDiff method, we can remove the player field and further optimise using dp
// Difference method
class Solution {
    public boolean predictTheWinner(int[] nums) {
        int diff = getScoreDiff(nums, 0, nums.length - 1, 0);
        return diff >= 0? true: false;
    }

    private int getScoreDiff(int[] nums, int left, int right, int currPlayer) {
        if (left > right) {
            return 0;
        }

        if (left == right) {
            return nums[left];
        }

        return Math.max(nums[left] - getScoreDiff(nums, left + 1, right, 1 - currPlayer), nums[right] - getScoreDiff(nums, left, right - 1, 1 - currPlayer));
    }
}
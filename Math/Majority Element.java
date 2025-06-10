// https://leetcode.com/problems/majority-element/
class Solution {
    public int majorityElement(int[] nums) {
        // Works on the principle that count(majorityElement) - count(everyOtherElement) > 0
        int candidate = -1;
        int count = 0;

        for (int num: nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                if (candidate == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }
}

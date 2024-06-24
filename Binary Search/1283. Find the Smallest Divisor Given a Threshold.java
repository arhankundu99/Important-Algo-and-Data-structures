// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int minDivisor = 1;
        int maxDivisor = 1;
        int smallestDivisor = 1;
        for (int num: nums) {
            maxDivisor = Math.max(maxDivisor, num);
        }

        while (minDivisor <= maxDivisor) {
            int divisor = minDivisor + (maxDivisor - minDivisor) / 2;

            int sum = 0;
            for (int num: nums) {
                sum += Math.ceil(num / (1.0 * divisor));
            }

            if (sum <= threshold) {
                smallestDivisor = divisor;
                maxDivisor = divisor - 1;
            } else {
                minDivisor = divisor + 1;
            }
        }
        return smallestDivisor;
    }
}
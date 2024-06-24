// https://leetcode.com/problems/split-array-largest-sum/description/
class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int num: nums) {
            low = Math.max(low, num);
            high += num;
        }

        int minimizedLargestSum = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int count = 1, sum = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum > mid) {
                    sum = nums[i];
                    count++;
                }
            }

            System.out.println("Low: " + low + " " + "High: " + high + " " + "Mid: " + mid + " " + "Count: " + count);

            if (count <= k) {
                minimizedLargestSum = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minimizedLargestSum;
    }
}
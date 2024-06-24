// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1, high = (int)Math.pow(10, 9);
        int minDays = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int currBouquetsCount = 0;
            int currFlowerCount = 0;
            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] <= mid) {
                    currFlowerCount++;
                } else {
                    currFlowerCount = 0;
                }

                if (currFlowerCount == k) {
                    currBouquetsCount++;
                    currFlowerCount = 0;
                }
            }

            if (currBouquetsCount >= m) {
                high = mid - 1;
                minDays = mid;
            } else {
                low = mid + 1;
            }
        }
        return minDays;
    }
}
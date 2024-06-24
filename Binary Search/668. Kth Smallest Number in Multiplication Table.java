// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int min = 1, max = (m * n);
        int kthNum = -1;
        while (min <= max) {
            int mid = min + (max - min) / 2;

            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(mid / i, n);

                if (mid / i == 0) {
                    break;
                }
            }
            
            if (count >= k) {
                kthNum = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return kthNum;
    }
}
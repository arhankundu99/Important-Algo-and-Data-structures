// https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/description/
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] points = new int[52];

        for (int i = 0; i < ranges.length; i++) {
            points[ranges[i][0]]++;
            points[ranges[i][1] + 1]--;
        }

        int count = 0;
        for (int i = 0; i <= right; i++) {
            count += points[i];
            if (count <= 0 && i >= left) {
                return false;
            }
        }
        return true;
    }
}
// https://leetcode.com/problems/points-that-intersect-with-cars/description/
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] line = new int[102];

        for (List<Integer> num: nums) {
            line[num.get(0)]++;
            line[num.get(1) + 1]--;
        }

        int count = 0, numPoints = 0;

        for (int i = 1; i <= 100; i++) {
            count += line[i];
            if (count >= 1) {
                numPoints++;
            }
        }
        return numPoints;
    }
}
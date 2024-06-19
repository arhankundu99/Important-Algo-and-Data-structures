// https://leetcode.com/problems/maximum-population-year/description/
class Solution {
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> logMap = new HashMap<>();
        for(int[] log: logs) {
            logMap.put(log[0], logMap.getOrDefault(log[0], 0) + 1);
            logMap.put(log[1], logMap.getOrDefault(log[1], 0) - 1);
        }

        int maxPopulation = 0;
        int count = 0;
        int earliestYear = 1950;
        for (int year = 1950; year <= 2050; year++) {
            count += logMap.getOrDefault(year, 0);
            if (maxPopulation < count) {
                maxPopulation = count;
                earliestYear = year;
            }
        }
        return earliestYear;
    }
}
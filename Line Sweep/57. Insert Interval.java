// https://leetcode.com/problems/insert-interval/
// Becareful to handle new interval where x = y in [x, y]
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        TreeMap<Integer, Integer> line = new TreeMap<>();

        for(int[] interval: intervals) {
            line.put(interval[0], line.getOrDefault(interval[0], 0) + 1);
            line.put(interval[1], line.getOrDefault(interval[1], 0) - 1);
        }

        line.put(newInterval[0], line.getOrDefault(newInterval[0], 0) + 1);
        line.put(newInterval[1], line.getOrDefault(newInterval[1], 0) - 1);

        // [0, 1, 0, 0, 0, 0, -1]

        // [1, 0, 0, 0, 0, 0, -1]
        // [1, 1, 1, 1, 1, 1, 0]


        // 1, 0, 1, -1, -1, 1, 0, -1, 0
        // 1, 1, 2, 1, 0, 1, 1, 0, 0



        List<int[]> newIntervals = new ArrayList<>();

        int start = 0;
        boolean flag = false;
        int prefixSum = 0;
        for (int key: line.keySet()) {
            if (prefixSum == 0 && !flag) {
                start = key;
                flag = true;
            }
            prefixSum += line.get(key);
            // System.out.println(prefixSum + " " + flag);
            if (prefixSum == 0 && flag) {
                flag = false;
                newIntervals.add(new int[]{start, key});
            }
        }
        int[][] result = new int[newIntervals.size()][2];
        for(int idx = 0; idx < newIntervals.size(); idx++) {
            result[idx][0] = newIntervals.get(idx)[0];
            result[idx][1] = newIntervals.get(idx)[1];
        }
        return result;
    }
}
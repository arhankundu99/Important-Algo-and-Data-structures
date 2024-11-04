// https://leetcode.com/problems/remove-interval/description/
class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        TreeMap<Integer, Integer> line = new TreeMap<>();
        for (int[] interval: intervals) {
            line.put(interval[0], line.getOrDefault(interval[0], 0) + 1);
            line.put(interval[1], line.getOrDefault(interval[1], 0) - 1);
        }

        line.put(toBeRemoved[0], line.getOrDefault(toBeRemoved[0], 0) - 1);
        line.put(toBeRemoved[1], line.getOrDefault(toBeRemoved[1], 0) + 1);

        int sum = 0;
        boolean flag = false;

        List<List<Integer>> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry: line.entrySet()) {
            int point = entry.getKey();
            int count = entry.getValue();

            sum += count;

            if (sum == 1) {
                result.add(new ArrayList<>());
                result.get(result.size() - 1).add(point);
                flag = true;
            }

            if (sum == 0 && flag) {
                result.get(result.size() - 1).add(point);
                flag = false;
            }
        }
        return result;
    }
}
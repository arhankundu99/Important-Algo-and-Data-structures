// https://leetcode.com/problems/single-threaded-cpu/
// Time: NlogN
class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] tasksWithIndex = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            tasksWithIndex[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(tasksWithIndex, new Comparator<int[]>() {
            public int compare(int[] task1, int[] task2) {
                return task1[0] == task2[0]? task1[1] - task2[1]: task1[0] - task2[0];
            }
        });

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] task1, int[] task2) {
                return task1[1] == task2[1]? task1[2] - task2[2]: task1[1] - task2[1];
            }
        });

        int currIdx = 0;
        int orderIdx = 0;
        int[] orders = new int[tasks.length];
        int currTime = 0;

        while (currIdx < tasks.length || queue.size() != 0) {
            // Add all the candidates now
            while (currIdx < tasks.length && tasksWithIndex[currIdx][0] <= currTime) {
                queue.add(tasksWithIndex[currIdx++]);
            }

            // Choose a candidate now
            if (queue.size() != 0) {
                int[] chosenTask = queue.poll();
                currTime += chosenTask[1];
                orders[orderIdx++] = chosenTask[2];
            } else if (currIdx < tasks.length) {
                int[] chosenTask = tasksWithIndex[currIdx];
                currTime = chosenTask[0] + chosenTask[1];
                orders[orderIdx++] = chosenTask[2];
                currIdx++;
            }
        }
        return orders;
    }
}
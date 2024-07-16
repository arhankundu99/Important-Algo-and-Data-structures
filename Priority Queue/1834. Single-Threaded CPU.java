// https://leetcode.com/problems/single-threaded-cpu/
class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] tasksWithIndex = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            tasksWithIndex[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(tasksWithIndex, new Comparator<int[]>() {
            public int compare(int[] task1, int[] task2) {
                return task1[0] - task2[0] == 0? task1[1] - task2[1]: task1[0] - task2[0];
            }
        });

        int[] order = new int[tasks.length];
        int orderIdx = 0;
        int currTime = 0;
        int currIdx = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] task1, int[] task2) {
                return task1[1] - task2[1] == 0? task1[2] - task2[2]: task1[1] - task2[1];
            }
        });
        while (orderIdx < order.length) {
            while (currIdx < tasksWithIndex.length && tasksWithIndex[currIdx][0] <= currTime) {
                queue.add(tasksWithIndex[currIdx]);
                currIdx++;
            }

            if (queue.size() != 0) {
                int[] chosenTask = queue.poll();
                order[orderIdx++] = chosenTask[2];
                currTime = currTime + chosenTask[1];

            } else {
                int[] chosenTask = tasksWithIndex[currIdx];
                order[orderIdx++] = chosenTask[2];
                currTime = chosenTask[0] + chosenTask[1];
                currIdx++;
            }

        }
        return order;
    }
}
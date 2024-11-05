// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
// Time: O(NlogN)
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            public int compare(int[] event1, int[] event2) {
                return event1[0] == event2[0]? event1[1] - event2[1]: event1[0] - event2[0];
            }
        });

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] event1, int[] event2) {
                return event1[1] - event2[1];
            }
        });

        int currTime = 0, currIdx = 0;
        int count = 0;
        while (currIdx < events.length || queue.size() != 0) {
            // Remove all expired events
            while (queue.size() != 0 && queue.peek()[1] < currTime) {
                queue.poll();
            }

            // Add all the candidates
            while (currIdx < events.length && events[currIdx][0] <= currTime) {
                queue.add(events[currIdx]);
                currIdx++;
            }

            // Select a candidate
            if (queue.size() != 0) {
                int[] chosenEvent = queue.poll();
                currTime = currTime + 1;
                count++;
            } else if (currIdx < events.length) {
                int[] chosenEvent = events[currIdx];
                currTime = chosenEvent[0] + 1;
                count++;
                currIdx++;
            }
        }
        return count;
    }
}
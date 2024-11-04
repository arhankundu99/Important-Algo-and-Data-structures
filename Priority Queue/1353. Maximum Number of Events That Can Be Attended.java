// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
// Time: O(D + NlogN) where D is maxDay (in this case, it is 10^5 and N is number of events)
// Because the current day's inner loop will run at most NlogN times.
class Solution {
    public int maxEvents(int[][] events) {
        // Sort the events based on current day
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

        int count = 0, eventIdx = 0;
        for (int currentDay = 0; currentDay <= 100000; currentDay++) {
            // Remove expired events
            while (queue.size() != 0 && queue.peek()[1] < currentDay) {
                queue.poll();
            }

            // Add candidates
            while (eventIdx < events.length && events[eventIdx][0] <= currentDay) {
                queue.add(events[eventIdx++]);
            }

            // Pick a candidate for the current day
            if (queue.size() != 0) {
                int[] chosenEvent = queue.poll();
                count++;
            }
        }
        return count;

        // Initialise a priority queue

        // iterate current day from 0 to max_day
        //       remove expired events
        //       add candidates
        //       pick a candidate
    }
}
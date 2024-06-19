// https://www.interviewbit.com/problems/meeting-rooms/
// Note: TreeMap does not contain getOrDefault method in older versions of java
import java.util.*;
public class Solution {
    public int solve(int[][] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] time: A) {
           // Increment count at start time
            if (!map.containsKey(time[0])) {
                map.put(time[0], 1);
            } else {
                map.put(time[0], map.get(time[0]) + 1);
            }
            
            // Decrement count just after end time
            int end = time[1];  // Adjust end time to handle intervals correctly
            if (!map.containsKey(end)) {
                map.put(end, -1);
            } else {
                map.put(end, map.get(end) - 1);
            }
        }
        
        int count = 0;
        int maxCount = 0;
        for(int key: map.keySet()) {
            count += map.get(key);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}

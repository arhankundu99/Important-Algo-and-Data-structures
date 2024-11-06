// https://leetcode.com/problems/odd-even-jump/description/
// Problem description
// You need to take a jump from each index and if you are able to get to the end of the line (array) from an index, that jump is a good jump.
// A jump starts with an odd jump and alternates with an even jump until you get to the end of the line or you can no longer take a step.

// An odd jump is when you are able to jump to an index ahead of your starting point, such that the value at the index jumped to is greater than or equal to the value of your current position. It also needs to be the minimum of all possible values available.
// e.g: 3, 1, 2, 7,15,4,9; taking an odd jump at index 0 will land you at index 4. Notice also you can't take any odd jump at index 3.

// An even jump is when you are able to jump to a position ahead such that the value at the position you jumped to is less than or equal to the current value. Where there are multiple values, you have to land at the value that is the maximum of all possible values.
// For example: 3, 1, 2, 7,15,4,9; If you do an even jump at index 0, you will land at index 2. Notice that you cannot do an even jump from index 1.

// We can only start with odd jumps

class Solution {
    public int oddEvenJumps(int[] arr) {
        // Create a dp array 
        // dp[i][0] => represents whether we can reach arr.length - 1 with odd step
        // dp[i][1] => represents whether we can reach arr.length - 1 with even step
        // dp[arr.length - 1][0] = true
        // dp[arr.length - 1][1] = true

        // for i from arr.length - 2...0
        //       get next greater value
        //       dp[i][0] = dp[next_greater_value.index][1]

        //       get next smaller value
        //       dp[i][1] = dp[next_smaller_value.index][0]


        // Count the number of dp[i][0] = true

        boolean[][] dp = new boolean[arr.length][2];
        dp[arr.length - 1][0] = true;
        dp[arr.length - 1][1] = true;
        int count = 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[arr.length - 1], arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            // get next greater value
            Integer nextGreaterValue = map.ceilingKey(arr[i]);
            if (nextGreaterValue != null) {
                dp[i][0] = dp[map.get(nextGreaterValue)][1];
            }

            // Get next smaller value
            Integer nextSmallerValue = map.floorKey(arr[i]);
            if (nextSmallerValue != null) {
                dp[i][1] = dp[map.get(nextSmallerValue)][0];
            }

            if (dp[i][0]) {
                count++;
            }

            map.put(arr[i], i);
        }
        return count;
    }
}
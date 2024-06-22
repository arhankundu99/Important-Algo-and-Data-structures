// https://algo.monster/liteproblems/2158
// There is a long and thin painting that can be represented by a number line. You are given a 0-indexed 2D integer array{" "} paint of length n, where{" "} paint[i] = [starti, endi] . This means that on the{" "} ith {" "} day you need to paint the area between{" "} starti {" "} and{" "} endi .

// Painting the same area multiple times will create an uneven painting so you only want to paint each area of the painting at most once.

// Return an integer array worklog of length n , where worklog[i] {" "} is the amount of new area that you painted on the{" "} ith day.

class Solution {
    public int[] amountPainted(int[][] paint) {
        TreeSet<Integer> unpainted = new TreeSet<>();
        int[] ans = new int[paint.length];
        for (int i = 0; i <= 50000; i++) {
            unpainted.add(i);
        }
        for (int i = 0; i < paint.length; i++) {
            int left = paint[i][0], right = paint[i][1];
            // Repeatedly delete the first element >= left until it becomes >= right
            // This clears values in [left, right) from the TreeSet
            while (true) {
                int next = unpainted.ceiling(left);
                if (next >= right)
                    break;
                unpainted.remove(next);
                ans[i]++;
            }
        }
        return ans;
    }
}
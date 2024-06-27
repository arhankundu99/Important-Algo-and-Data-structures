// https://leetcode.com/problems/maximum-score-from-removing-stones/description/
class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(a);
        queue.add(b);
        queue.add(c);
        int score = 0;
        while (true) {
            int x = queue.poll();
            int y = queue.poll();
            int z = queue.poll();

            if ((x == 0 && y == 0) || (y == 0 && z == 0) || (x == 0 && z == 0)) {
                break;
            }
            // System.out.println(x + " " + y + " " + z);
            if (x != 0) {
                x--;
            } else {
                y--;
            }
            z--;
            score++;

            queue.add(x);
            queue.add(y);
            queue.add(z);
        }
        return score;
    }
}
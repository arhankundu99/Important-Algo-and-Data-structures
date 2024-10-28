// https://leetcode.com/discuss/interview-question/5004476/Google-L5-Round-1
public boolean isValid(int nums[]) {
    int len = nums.length;
    if (len % 2 != 0) {
        return false;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int num : nums) {
        queue.add(num);
    }
    while (queue.size() > 1) {
        int size = queue.size();
        for (int i = 0; i < size; i += 2) {
            int player1 = queue.poll();
            int player2 = queue.poll();
            if (player1 + player2 != size + 1) {
                return false;
            }
            queue.add(Math.min(player1, player2));
        }
    }
    return true;
}
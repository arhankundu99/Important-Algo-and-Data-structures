// https://leetcode.com/problems/next-greater-element-ii/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Pair> stack = new Stack<>();
        Arrays.fill(result, -1);

        for (int i = 0; i < 2 * nums.length; i++) {
            int idx = i % nums.length;
            while (stack.size() != 0 && stack.peek().val < nums[idx]) {
                result[stack.pop().idx] = nums[idx];
            }
            stack.push(new Pair(nums[idx], idx));
        }
        return result;
    }
}
class Pair {
    int val;
    int idx;
    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
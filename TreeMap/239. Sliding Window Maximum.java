// https://leetcode.com/problems/sliding-window-maximum/description/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = treeMap.lastKey();
        int idx = 1;

        for (int i = k; i < nums.length; i++) {
            treeMap.put(nums[i - k], treeMap.get(nums[i - k]) - 1);
            if (treeMap.get(nums[i - k]) == 0) {
                treeMap.remove(nums[i - k]);
            }
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
            result[idx++] = treeMap.lastKey();
        }
        return result;
    }
}
// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int i = 0, j = 0, count = 0;
        while (j < nums.length) {
            treeMap.put(nums[j], treeMap.getOrDefault(nums[j], 0) + 1);

            int firstKey = treeMap.firstKey();
            int lastKey = treeMap.lastKey();

            while (nums[j] - firstKey > limit || lastKey - nums[j] > limit) {
                treeMap.put(nums[i], treeMap.get(nums[i]) - 1);
                if (treeMap.get(nums[i]) == 0) {
                    treeMap.remove(nums[i]);
                }
                i++;
                firstKey = treeMap.firstKey();
                lastKey = treeMap.lastKey();
            }

            count = Math.max(count, j - i + 1);
            System.out.println(i + " " + j + " " + count);
            j++;
        }
        return count;
    }
}
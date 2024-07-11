// https://leetcode.com/problems/longest-increasing-subsequence/
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> subsequence = new ArrayList<>();
        subsequence.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (subsequence.get(subsequence.size() - 1) < nums[i]) {
                subsequence.add(nums[i]);
            } else {
                int left = 0, right = subsequence.size() - 1;

                int idx = -1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (subsequence.get(mid) >= nums[i]) {
                        idx = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                if (idx == -1) {
                    idx = 0;
                }

                subsequence.set(idx, nums[i]);
            }
        }

        return subsequence.size();
    }
}
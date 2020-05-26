//leetcode prob no 525
//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer>map = new HashMap<>();
        map.put(0,-1);
        int currSum = 0, ans = 0;
        for(int i=0;i<nums.length;i++)
        {
            currSum += (nums[i]*2-1); 
            if(map.containsKey(currSum))
                ans = Math.max(ans, i-map.get(currSum));
            else map.put(currSum, i);
        }
        return ans;
    }
}

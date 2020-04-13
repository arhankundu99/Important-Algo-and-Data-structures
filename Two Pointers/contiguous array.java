//leetcode prob no 525
//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer>map = new HashMap<>();
        map.put(0,-1);
        int count0=0, count1=0, ret=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == 0)count0++;
            else count1++;
            int diff = count0-count1;
            if(map.containsKey(diff))ret = Math.max(ret,i-map.get(diff));
            else map.put(diff, i);
        }
        return ret;
    }
}

// leetcode prob 457
// Difficulty : Medium

/*You are given a circular array nums of positive and negative integers. 
If a number k at an index is positive, then move forward k steps. 
Conversely, if it's negative (-k), move backward k steps. 
Since the array is circular, you may assume that the last element's next element is the first element, 
and the first element's previous element is the last element.

Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. 
Furthermore, movements in a cycle must all follow a single direction. 
In other words, a cycle must not consist of both forward and backward movements.
*/

class Solution {
    Map<Integer, Integer>mapR;
    Map<Integer, Integer>mapL;
    public boolean circularArrayLoop(int[] nums) {
        
        mapR = new HashMap<>();
        mapL = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] > 0)mapR.put(i, (i + nums[i]) % nums.length);
            else mapL.put(i, (nums.length + ((i + nums[i]) % nums.length)) % nums.length);
        }
        
        boolean []vis = new boolean[nums.length];
        boolean []rec = new boolean[nums.length];
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] >= 0 && dfs(mapR, i, vis, rec,nums[i]))return true;
            else if(dfs(mapL, i, vis, rec,nums[i]))return true;   
        } 
        return false;
    }
    public boolean dfs(Map<Integer, Integer>map, int idx, boolean[] vis, boolean[] rec, int num)
    {
        if(!map.containsKey(idx))return false;
        
        if(rec[idx])return !(map.get(idx) == idx);

        if(vis[idx])return false;
        
        rec[idx] = true;
        vis[idx] = true;
        
        if(dfs(map, map.get(idx), vis, rec, num))return true;
        
        rec[idx] = false;
        
        return false;
    }
}

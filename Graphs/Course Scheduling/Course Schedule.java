// leetcode prob 207
// Difficulty: Medium
// Problem Link: https://leetcode.com/problems/course-schedule/

class Solution {
    Map<Integer, Set<Integer>>map;
    boolean[] vis, rec;
    public boolean canFinish(int num, int[][] pre) {
        
        map = new HashMap<>();
        vis = new boolean[num];
        rec = new boolean[num];
        
        for(int i=0;i<num;i++)map.put(i, new HashSet<>());
        
        for(int i=0;i<pre.length;i++)map.get(pre[i][0]).add(pre[i][1]);
        
        for(int i: map.keySet())
            if(!vis[i] && hasCycle(i))return false;
        
        return true;
    }
    public boolean hasCycle(int idx)
    {
        if(rec[idx])return true;
        if(vis[idx])return false;
        
        rec[idx] = true;
        vis[idx] = true;
        
        for(int i: map.get(idx))
            if(hasCycle(i))return true;
        
        rec[idx] = false;
        return false;
    }
}

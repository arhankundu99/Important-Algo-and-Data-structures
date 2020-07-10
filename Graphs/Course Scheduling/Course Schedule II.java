//leetcode problem 210
//Difficulty: Medium
//Problem Link: https://leetcode.com/problems/course-schedule-ii/
//NOTE: We CANNOT DO TOPO SORT FOR CYCLIC GRAPHS

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer>[]graph = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++)graph[i] = new ArrayList<>();
        
        for(int i = 0; i < prerequisites.length; i++)
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        
        if(isCyclic(graph))return new int[0];
        
        boolean[] vis = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < numCourses; i++)dfs(i, vis, stack, graph);
        
        int[] res = new int[numCourses];
        int idx = 0;
        
        while(!stack.isEmpty())res[res.length-1-idx++] = stack.pop();
        
        return res;
    }
    public void dfs(int idx, boolean[] vis, Stack<Integer>stack, ArrayList<Integer>[] graph)
    {
        if(vis[idx])return;
        
        vis[idx] = true;
        
        for(int i = 0; i < graph[idx].size(); i++)dfs(graph[idx].get(i), vis, stack, graph);
        
        stack.push(idx);
    }
    public boolean isCyclic(ArrayList<Integer>[] graph)
    {
        boolean[] rec = new boolean[graph.length];
        boolean[] vis = new boolean[graph.length];
        
        for(int i = 0; i < graph.length; i++)
            if(isCyclic(graph, i, rec, vis))return true;
        
        return false;
    }
    public boolean isCyclic(ArrayList<Integer>[] graph, int idx, boolean[] rec, boolean[] vis)
    {
        if(rec[idx])return true;
        if(vis[idx])return false;
        
        rec[idx] = true;
        vis[idx] = false;
        
        for(int i = 0; i < graph[idx].size(); i++)
            if(isCyclic(graph, graph[idx].get(i), rec, vis))return true;
        
        rec[idx] = false;
        return false;
    }
}

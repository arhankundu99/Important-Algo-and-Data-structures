//refer https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
//Detect cycle in a graph
class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];
        for(int i=0;i<V;i++)
            if(dfs(i,list,vis, rec))return true;
        return false;
    }
    static boolean dfs(int idx, ArrayList<ArrayList<Integer>>list, boolean[] vis, boolean[]rec)
    {
        if(rec[idx])return true;
        if(vis[idx])return false;
        
        vis[idx] = true;
        rec[idx] = true;
        
        for(int i = 0; i < list.get(idx).size(); i++)
            if(dfs(list.get(idx).get(i),list,vis,rec))return true;
        
        rec[idx] = false; 
        return false;
    }
}

// why this works?
// we are storing the nodes in rec which are currently in recursion stack
// so if we find an element which was already present in the rec array, then we have detected a cycle
// now if we encounter an element which we have already visited, then a cycle is not possible 

// Time complexity: O(V+E) because we are ultimately traversing the adjacency list only.
// Extra auxilary space: O(V)

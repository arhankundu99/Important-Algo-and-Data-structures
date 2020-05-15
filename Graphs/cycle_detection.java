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

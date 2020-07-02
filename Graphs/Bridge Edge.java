// https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1
// Difficulty : Medium
class Solution {

    public boolean isBridge(Graph adj, int s, int e) {
        if(s == e)return false;
        boolean[]vis = new boolean[adj.v+1];
        vis[s] = true;
        for(int i = 0; i < adj.edges[s].size(); i++)
        {
            if(adj.edges[s].get(i) == e)continue;
            if(dfs(adj, adj.edges[s].get(i), e, vis))return false;
        }
        return true;
    }
    public boolean dfs(Graph adj, int s, int e, boolean[]vis){
        if(vis[s])return false;
        vis[s] = true;
        if(s == e)return true;
        for(int i = 0; i < adj.edges[s].size(); i++)
            if(dfs(adj, adj.edges[s].get(i), e, vis))return true;

        return false;
    }
}
//My approach: u and v are directly connected. If u -> v is a bridge, that means there must be no other path from u to v and if a path exists, that means the given edge
//is not a bridge

//Another Approach: remove the given edge and check the number of disconnnected graphs, if the number is 2, then the given edge is a bridge

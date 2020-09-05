// https://leetcode.com/problems/redundant-connection/
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        dsu dsu = new dsu(edges.length+1);
        
        for(int i = 0; i < edges.length; i++){
            if(dsu.union(edges[i][0], edges[i][1]))return edges[i];
        }
        return new int[2];
    }
}
class dsu{
    int[] parent;
    int[] rank;
    dsu(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++)parent[i] = i;
    }
    int find(int x){
        if(parent[x] == x)return x;
        return parent[x] = find(parent[x]);
    }
    boolean union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y)return true;
        if(rank[x] > rank[y]){
            parent[y] = x;
        }
        else if(rank[y] > rank[x]){
            parent[x] = y;
        }
        else{
            parent[x] = y;
            rank[y]++;
        }
        return false;
    }
}

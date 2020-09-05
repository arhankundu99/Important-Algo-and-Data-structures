// https://leetcode.com/problems/number-of-operations-to-make-network-connected/
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int count = 0;
        dsu dsu = new dsu(n);
        for(int[] c: connections){
            if(dsu.union(c[0], c[1]))count++;
        } 
        int disconnected = 0;
        for(int i=0; i < dsu.parent.length; i++){
            if(dsu.parent[i] == i)disconnected++;
        }
        if(disconnected - 1 <= count)return disconnected-1;
        return -1;
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

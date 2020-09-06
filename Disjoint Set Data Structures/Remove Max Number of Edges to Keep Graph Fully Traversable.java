// https://leetcode.com/contest/weekly-contest-205/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, new Comparator<int[]>(){
            public int compare(int[] edge1, int[] edge2){
                return edge2[0] - edge1[0];
            }
        });
        dsu dsuA = new dsu(n+1);
        dsu dsuB = new dsu(n+1);
        
        int remove = 0;
        
        for(int[] edge: edges){
            if(edge[0] == 3){
                int xRepA = dsuA.find(edge[1]);
                int yRepA = dsuA.find(edge[2]);
                
                int xRepB = dsuB.find(edge[1]);
                int yRepB = dsuB.find(edge[2]);
                
                if(xRepA == yRepA && xRepB == yRepB)remove++;
                else{
                    dsuA.union(edge[1], edge[2]);
                    dsuB.union(edge[1], edge[2]);
                }
            }
            else if(edge[0] == 2){
                int xRepB = dsuB.find(edge[1]);
                int yRepB = dsuB.find(edge[2]);
                
                if(xRepB == yRepB)remove++;
                else dsuB.union(xRepB, yRepB);
            }
            else if(edge[0] == 1){
                int xRepA = dsuA.find(edge[1]);
                int yRepA = dsuA.find(edge[2]);
                
                if(xRepA == yRepA)remove++;
                else dsuA.union(xRepA, yRepA);
            }
        }
        if(dsuA.maxSize != n || dsuB.maxSize != n)return -1;
        return remove;
    }
}
class dsu{
    int[] parent;
    int[] rank;
    int[] size;
    int maxSize;
    dsu(int n){
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        maxSize = 0;
        for(int i = 0; i < n; i++)size[i] = 1;
        for(int i = 0; i < n; i++)parent[i] = i;
    }
    int find(int x){
        if(x == parent[x])return x;
        return parent[x] = find(parent[x]);
    }
    void union(int x, int y){
        int xRep = find(x);
        int yRep = find(y);
        
        if(xRep == yRep)return;
        
        if(rank[xRep] > rank[yRep]){
            parent[yRep] = xRep;
            size[xRep] += size[yRep];
            maxSize = Math.max(maxSize, size[xRep]);
        }
        else if(rank[yRep] > rank[xRep]){
            parent[xRep] = yRep;
            size[yRep] += size[xRep];
            maxSize = Math.max(maxSize, size[yRep]);
        }
        else{
            parent[yRep] = xRep;
            size[xRep] += size[yRep];
            maxSize = Math.max(maxSize, size[xRep]);
            rank[xRep]++;
        }
    }
}

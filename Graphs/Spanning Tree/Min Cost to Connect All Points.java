// https://leetcode.com/problems/min-cost-to-connect-all-points/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int cost = 0;
        uf uf = new uf(points.length);
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });
        
        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                queue.add(new int[]{i, j, getDist(points, i, j)});
            }
        }
        while(queue.size() != 0){
            int[] poll = queue.poll();
            int u = poll[0];
            int v = poll[1];
            int w = poll[2];
            
            int uRep = uf.find(u);
            int vRep = uf.find(v);
            
            if(uRep == vRep)continue;
            
            cost += w;
            uf.union(u, v);
        }
        return cost;
    }
    public int getDist(int[][] points, int i, int j){
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}
class uf{
    int[] parent;
    int[] rank;
    
    uf(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++)parent[i] = i;
        rank = new int[n];
    }
    int find(int x){
        if(x == parent[x])return x;
        return parent[x] = find(parent[x]);
    }
    void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y)return;
        
        if(rank[x] > rank[y]){
            parent[y] = x;
        }
        else if(rank[x] < rank[y]){
            parent[x] = y;
        }
        else{
            parent[x] = y;
            rank[y]++;
        }
    }
}

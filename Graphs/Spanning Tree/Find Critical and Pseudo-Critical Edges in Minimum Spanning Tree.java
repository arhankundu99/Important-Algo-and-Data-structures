// https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        Map<int[], Integer>map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            map.put(edges[i], i);
        }
        
        //sort the edges according to edge weights in ascending order
        Arrays.sort(edges, new Comparator<int[]>(){
           public int compare(int[] edge1, int[] edge2){
               return edge1[2] - edge2[2];
           } 
        });
        
        
        int minCost = buildMST(edges, n, null, null);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        
        int idx = 0;
        for(int[] edge: edges){
            int costWithout = buildMST(edges, n, null, edge);
            int costWith = buildMST(edges, n, edge, null);
            
            if(costWithout > minCost){
                list.get(0).add(map.get(edge));
            }
            else if(costWith == minCost){
                list.get(1).add(map.get(edge));
            }
        }
        return list;
    }
    public int buildMST(int[][] edges, int n, int[] pick, int[] skip){
        uf uf = new uf(n);
        int minCost = 0;
        
        if(pick != null){
            uf.union(pick[0], pick[1]);
            minCost += pick[2];
        }
        
        for(int[] edge: edges){
            if(edge == skip)continue;
            
            int u = edge[0];
            int v = edge[1];
            
            int uRep = uf.find(u);
            int vRep = uf.find(v);
            
            if(uRep == vRep)continue;
            
            minCost += edge[2];
            uf.union(u, v);
        }
        return uf.count == 1? minCost: Integer.MAX_VALUE;
    } 
}
class uf{
    int[] parent;
    int[] rank;
    int count; //count will store the number of sets
    
    uf(int n){
        parent = new int[n];
        rank = new int[n];
        count = n;
        
        for(int i = 0; i < n; i++)parent[i] = i;
    }
    int find(int x){
        if(parent[x] == x)return x;
        return parent[x] = find(parent[x]);
    }
    void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y)return;
        
        count--;
        if(rank[x] > rank[y])parent[y] = x;
        else if(rank[y] > rank[x])parent[x] = y;
        else{
            parent[x] = y;
            rank[y]++;
        }
    }
}

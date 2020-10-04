// https://leetcode.com/problems/shortest-path-visiting-all-nodes/
class Solution {
    int inf = 1000000;
    int[][] dp;
    public int shortestPathLength(int[][] graph) {
        dp = new int[graph.length][1<<graph.length];
        
        int[][] dist = new int[graph.length][graph.length];
        
        for(int i = 0; i < graph.length; i++)
            Arrays.fill(dp[i], inf);
        
        for(int i = 0; i < graph.length; i++)Arrays.fill(dist[i], inf);
        
        for(int i = 0; i < graph.length; i++)dist[i][i] = 0;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < graph.length; i++)map.put(i, new HashSet<>());
        
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                
                map.get(i).add(graph[i][j]);
                map.get(graph[i][j]).add(i);
                
                dist[i][graph[i][j]] = 1;
                dist[graph[i][j]][i] = 1;
            }
        }
        
        for(int k = 0; k < graph.length; k++){
            for(int i = 0; i < graph.length; i++){
                for(int j = 0; j < graph.length; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        
        int length = inf;
        for(int i = 0; i < graph.length; i++){
            length = Math.min(length, dfs(map, dist, i, 1<<i));
        }
        return length;
    }
    public int dfs(Map<Integer, Set<Integer>> map, int[][] dist, int u, int mask){
        if(mask == (1 << map.size())-1)return 0;
        
        if(dp[u][mask] != inf)return dp[u][mask];
        
        for(int i = 0; i < map.size(); i++){
            if((mask & (1<<i)) != 0)continue;
            if(dist[u][i] == inf)continue;
            
            dp[u][mask] = Math.min(dp[u][mask], dist[u][i]+dfs(map, dist, i, mask | (1<<i)));    
        }
        return dp[u][mask];
    }
}

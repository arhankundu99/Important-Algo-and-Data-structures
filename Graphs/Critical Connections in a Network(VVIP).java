// https://leetcode.com/problems/critical-connections-in-a-network/

// brute force solution O(E*(V+E)) TLE
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //brute force solution
        List<List<Integer>>ans = new ArrayList<>();
        Map<Integer, Set<Integer>>map = new HashMap<>();
        for(List<Integer> connection: connections){
            if(!map.containsKey(connection.get(0)))map.put(connection.get(0), new HashSet<>());
            if(!map.containsKey(connection.get(1)))map.put(connection.get(1), new HashSet<>());
            
            map.get(connection.get(0)).add(connection.get(1));
            map.get(connection.get(1)).add(connection.get(0));
        }
        for(List<Integer> connection: connections){
            //removing a connection and checking if the graph is still connected.
            map.get(connection.get(0)).remove(connection.get(1));
            if(map.get(connection.get(0)).size() == 0)map.remove(connection.get(0));
            
            map.get(connection.get(1)).remove(connection.get(0));
            if(map.get(connection.get(1)).size() == 0)map.remove(connection.get(1));
            
            boolean[] vis = new boolean[n];
            int count = 0;
            for(int u: map.keySet()){
                count = dfs(map, u, vis);
                break;
            }
            if(count != n){
                List<Integer>list = new ArrayList<>();
                list.add(connection.get(0));
                list.add(connection.get(1));
                
                ans.add(list);
            }
            if(!map.containsKey(connection.get(0)))map.put(connection.get(0), new HashSet<>());
            if(!map.containsKey(connection.get(1)))map.put(connection.get(1), new HashSet<>());
            
            map.get(connection.get(0)).add(connection.get(1));
            map.get(connection.get(1)).add(connection.get(0));
            
        }
        return ans;
    }
    public int dfs(Map<Integer, Set<Integer>>map, int u, boolean[] vis){
        if(vis[u])return 0;
        vis[u] = true;
        
        int count = 0;
        for(int v: map.get(u)){
            count += dfs(map, v, vis);
        }
        return count+1;
    }
}

// O(V+E) solution
class Solution {
    List<List<Integer>>ans;
    Map<Integer, Set<Integer>>map;
    int[] disc; // disc[i] stores the time when er encounter ith vertex
    int[] low; // low[i] stores the min of disc times of its adjacent nodes
    boolean[] vis;
    int currTime;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        disc = new int[n];
        low = new int[n];
        vis = new boolean[n];
        currTime = 0;
        
        for(List<Integer> connection: connections){
            int u = connection.get(0);
            int v = connection.get(1);
            
            if(!map.containsKey(u))map.put(u, new HashSet<>());
            if(!map.containsKey(v))map.put(v, new HashSet<>());
            
            map.get(u).add(v);
            map.get(v).add(u);
        }
        
        for(int i = 0; i < n; i++){
            if(!vis[i])dfs(i, -1);
        }
        return ans;
    }
    public void dfs(int u, int parent){
        vis[u] = true;
        disc[u] = currTime;
        low[u] = currTime;
        currTime++;
        
        for(int v: map.get(u)){
            if(parent == v)continue;
            if(vis[v]){
                low[u] = Math.min(low[u], low[v]);
            }
            else{
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                
                if(low[v] > disc[u]){
                    List<Integer>list = new ArrayList<>();
                    list.add(u);
                    list.add(v);
                    ans.add(list);
                }
            }
        }
    }
}

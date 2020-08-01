## Graphs

More Problems: <br />
<https://www.geeksforgeeks.org/check-loop-array-according-given-constraints/> <br />
<https://www.geeksforgeeks.org/detect-cycle-in-a-graph/> <br />
<https://www.geeksforgeeks.org/print-all-the-cycles-in-an-undirected-graph/> <br />
<https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/> <br />
<https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/> <br />

## DFS vs BFS

1. DFS uses stack to traverse the graph and BFS uses queue to traverse the graph.
2. DFS is used in decision making problems and BFS can be used to find shortest distance in an unweighted graph.
3. Both have same time complexity: O(V+E)
4. BFS is slower than DFS.

#### DO NOT USE DFS TO CALCULATE SHORTEST DISTANCE UNLESS YOU USE DP

<https://www.geeksforgeeks.org/cycles-of-length-n-in-an-undirected-and-connected-graph/#:~:text=Source%20Shortest%20Path-,Cycles%20of%20length%20n%20in%20an%20undirected%20and%20connected%20graph,n%20vertices%20and%20n%20edges.> <br/>
To find cycles of length n: use dfs and find the paths of length n-1. if the current vertex has an edge with the starting vertex, then increment count

## Finding Bridges
```java
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
                low[u] = Math.min(low[u], disc[v]);
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
```

## Finding Articulation point
```java
class Solution {
    List<Integer>ans;
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
        int children = 0;
        
        for(int v: map.get(u)){
            if(parent == v)continue;
            if(vis[v]){
                low[u] = Math.min(low[u], disc[v]);
            }
            else{
                children++;
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                
                if(parent[u] == -1 && children > 1)ans.add(u);
                if(parent[u] != -1 && low[v] >= disc[u])ans.add(u);
            }
        }
    }
}
```

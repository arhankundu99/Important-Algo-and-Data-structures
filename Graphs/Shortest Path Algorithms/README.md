# Floyd Warshall Algorithm

This algorithm is used to find shortest distances between all nodes in a graph. (This algorithm also works for negative edges) <br />
This algorithm is an example of dynamic programming.

## Java Code:

```
void floydWarshall(int graph[][]) 
{ 
    int dist[][] = new int[V][V]; 
    int i, j, k; 
    for (i = 0; i < V; i++) 
        for (j = 0; j < V; j++) 
            dist[i][j] = graph[i][j]; 
  
    for (k = 0; k < V; k++)  // k is the intermidiate vertex
    {  
        for (i = 0; i < V; i++)  // i is the starting vertex
        { 
            for (j = 0; j < V; j++) // j is the final vertex
            { 
                if (dist[i][k] + dist[k][j] < dist[i][j]) 
                    dist[i][j] = dist[i][k] + dist[k][j]; 
            } 
        } 
    }
}
```
Time complexity : O(V^3)

### Behaviour with negative cycles

 There is no shortest path between any pair of vertices i, j which form part of a negative cycle. <br />
 But This algorithm can be used to detect negative cycles in a graph. <br />
 
 Initially `dist[i][i] = 0`. The path [i...k...i] can improve only if there exists a negative cycle. <br />
 So after the algorithm, `dist[i][i] will be negative` if a negative cycle exists from i to i <br />
 
 ### Reconstruction of shortest paths
 
 Below is the pseudo code for reconstruction of paths
 
```
procedure FloydWarshallWithPathReconstruction() is
    for each edge (u, v) do
        dist[u][v] ← w(u, v)  // The weight of the edge (u, v)
        next[u][v] ← v
    for each vertex v do
        dist[v][v] ← 0
        next[v][v] ← v
    for k from 1 to |V| do // standard Floyd-Warshall implementation
        for i from 1 to |V|
            for j from 1 to |V|
                if dist[i][j] > dist[i][k] + dist[k][j] then
                    dist[i][j] ← dist[i][k] + dist[k][j]
                    next[i][j] ← next[i][k]
   
procedure Path(u, v)
    if next[u][v] = null then
        return []
    path = [u]
    while u ≠ v
        u ← next[u][v]
        path.append(u)
    return path
```
Some practice problems:

<https://leetcode.com/problems/network-delay-time/submissions/>

# Bellman-Ford Algorithm

Based on Dynamic Programming. <br/>

Below is the pseudo code:

```
function BellmanFord(list vertices, list edges, vertex source) is
    ::distance[], predecessor[]

    // This implementation takes in a graph, represented as
    // lists of vertices and edges, and fills two arrays
    // (distance and predecessor) about the shortest path
    // from the source to each vertex

    // Step 1: initialize graph
    for each vertex v in vertices do
        distance[v] := inf             // Initialize the distance to all vertices to infinity
        predecessor[v] := null         // And having a null predecessor
    
    distance[source] := 0              // The distance from the source to itself is, of course, zero

    // Step 2: relax edges repeatedly
    for i from 1 to size(vertices)−1 do //just |V|−1 repetitions; i is never referenced
        for each edge (u, v) with weight w in edges do
            if distance[u] + w < distance[v] then
                distance[v] := distance[u] + w
                predecessor[v] := u

    // Step 3: check for negative-weight cycles
    for each edge (u, v) with weight w in edges do
        if distance[u] + w < distance[v] then
            error "Graph contains a negative-weight cycle"

    return distance[], predecessor[]
```
We can also use bellman-ford algorithm to find all pair shortest paths and the time complexity will be O(V*V*E) (In the worst case the time complexity is O(V^4).

### Why are we iterating |V|-1 times?

The reason is the any shortest path between two edges has atmost |V|-1 times. If it has more than |V|-1 edges, then the graph contains a negative cycle. <br/>

Time Complexity: O(VE)  <br />
Best Case : O(E)

### Advantages over dijkstra's algo

It can be used in case of negative edge weigths and it can also be used to detect cycle in a graph.

## Dijkstra
<https://leetcode.com/problems/network-delay-time/>
```java
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){return a[1] - b[1];}
        });
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            
            if(!map.containsKey(u))map.put(u, new HashMap<>());
            
            map.get(u).put(v, w);
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, 10000000);
        
        dist[K] = 0;
        boolean[] vis = new boolean[N+1];
        
        queue.add(new int[]{K, 0});
        
        while(queue.size() != 0){
            int[] poll = queue.poll();
            int u = poll[0];
            
            if(vis[u])continue;
            vis[u] = true;
            
            if(map.containsKey(u)){
                for(int v: map.get(u).keySet()){
                    int w = map.get(u).get(v);
                    
                    if(dist[v] > dist[u] + w){
                        dist[v] = dist[u] + w;
                        queue.add(new int[]{v, dist[v]});
                    }
                }
            }
        }
        int delay = 0;
        for(int i = 1; i <= N; i++)delay = Math.max(delay, dist[i]);
        
        return delay >= 10000000? -1: delay;
    }
}
```
NOTE: Dijkstra algorithm DOES NOT work for negative edges because we have a visited array and the visited array will restrict any node to be processed more than once. If we remove the visited array, the algorithm will work for negative edges (NOTE: I am not talking about negative cycles) But the time complexity will no longer be O((V + E)logV) because the each node will be processed many times before finding the shortest distance.

Time Complexity Analysis:
```
Doubt in the analysis. somw websites and even wikipedia has the time complexity of (V + E)logV, and some has the time complexity of O(V + ElogE)
1:
The queue can contain a maximum of |E| elements. No edge is processed twice because of the visited array. Time complexity for adding or removing an element from queue would be O(LogE).
Therefore the complexity inside the while loop is O(ElogE). And the complexity before the while loop is O(V). Therefore the total complexity is O(V + ElogE).
```
O(V + ElogE) video: <https://www.youtube.com/watch?v=YMyO-yZMQ6g>
```
2:
Q is the priority Queue
size(Q) * (O(1) + log(size(Q)) + (E(avg) * (O(1) + log(size(Q)))))
size(Q) + size(Q)log(size(Q)) + size(Q)E(avg) + size(Q)Eavglog(size(Q))
V + VlogV + VEavg + VEavglogV
V + VlogV + E + ElogV
(V + E)logV
```
  

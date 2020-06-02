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


  

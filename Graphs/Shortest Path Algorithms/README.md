# Floyd Warshall Algorithm

This algorithm is used to find shortest distances between all nodes in a graph. (This algorithm also works for negative edges) <br />

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
  

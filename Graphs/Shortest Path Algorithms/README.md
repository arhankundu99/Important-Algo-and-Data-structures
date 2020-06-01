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
 But This algorithm can be used to detect negative cycles in a graph. < br />
 
 Initially `dist[i][i] = 0`. The path [i...k...i] can improve only if there exists a negative cycle. <br />
 So after the algorithm, `dist[i][i] will be negative` if a negative cycle exists from i to i <br />
  

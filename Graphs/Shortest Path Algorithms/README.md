# Floyd Warshall Algorithm

This algorithm is used to find shortest distances between all nodes in a graph. (This algorithm also works for negative edges) <br />

Java Code:

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

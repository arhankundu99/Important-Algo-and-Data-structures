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
```java
// Java implementation of Dijkstra's Algorithm  
// using Priority Queue 
import java.util.*; 
public class DPQ { 
    private int dist[]; 
    private Set<Integer> settled; 
    private PriorityQueue<Node> pq; 
    private int V; // Number of vertices 
    List<List<Node> > adj; 
  
    public DPQ(int V) 
    { 
        this.V = V; 
        dist = new int[V]; 
        settled = new HashSet<Integer>(); 
        pq = new PriorityQueue<Node>(V, new Node()); 
    } 
  
    // Function for Dijkstra's Algorithm 
    public void dijkstra(List<List<Node> > adj, int src) 
    { 
        this.adj = adj; 
  
        for (int i = 0; i < V; i++) 
            dist[i] = Integer.MAX_VALUE; 
  
        // Add source node to the priority queue 
        pq.add(new Node(src, 0)); 
  
        // Distance to the source is 0 
        dist[src] = 0; 
        while (settled.size() != V) { 
  
            // remove the minimum distance node  
            // from the priority queue  
            int u = pq.remove().node; 
  
            // adding the node whose distance is 
            // finalized 
            settled.add(u); 
  
            e_Neighbours(u); 
        } 
    } 
  
    // Function to process all the neighbours  
    // of the passed node 
    private void e_Neighbours(int u) 
    { 
        int edgeDistance = -1; 
        int newDistance = -1; 
  
        // All the neighbors of v 
        for (int i = 0; i < adj.get(u).size(); i++) { 
            Node v = adj.get(u).get(i); 
  
            // If current node hasn't already been processed 
            if (!settled.contains(v.node)) { 
                edgeDistance = v.cost; 
                newDistance = dist[u] + edgeDistance; 
  
                // If new distance is cheaper in cost 
                if (newDistance < dist[v.node]) 
                    dist[v.node] = newDistance; 
  
                // Add the current node to the queue 
                pq.add(new Node(v.node, dist[v.node])); 
            } 
        } 
    } 
  
    // Driver code 
    public static void main(String arg[]) 
    { 
        int V = 5; 
        int source = 0; 
  
        // Adjacency list representation of the  
        // connected edges 
        List<List<Node> > adj = new ArrayList<List<Node> >(); 
  
        // Initialize list for every node 
        for (int i = 0; i < V; i++) { 
            List<Node> item = new ArrayList<Node>(); 
            adj.add(item); 
        } 
  
        // Inputs for the DPQ graph 
        adj.get(0).add(new Node(1, 9)); 
        adj.get(0).add(new Node(2, 6)); 
        adj.get(0).add(new Node(3, 5)); 
        adj.get(0).add(new Node(4, 3)); 
  
        adj.get(2).add(new Node(1, 2)); 
        adj.get(2).add(new Node(3, 4)); 
  
        // Calculate the single source shortest path 
        DPQ dpq = new DPQ(V); 
        dpq.dijkstra(adj, source); 
  
        // Print the shortest path to all the nodes 
        // from the source node 
        System.out.println("The shorted path from node :"); 
        for (int i = 0; i < dpq.dist.length; i++) 
            System.out.println(source + " to " + i + " is "
                               + dpq.dist[i]); 
    } 
} 
  
// Class to represent a node in the graph 
class Node implements Comparator<Node> { 
    public int node; 
    public int cost; 
  
    public Node() 
    { 
    } 
  
    public Node(int node, int cost) 
    { 
        this.node = node; 
        this.cost = cost; 
    } 
  
    @Override
    public int compare(Node node1, Node node2) 
    { 
        return node1.cost - node2.cost;
    } 
} 
```
  

// leetcode problem 886
// Difficulty: Medium
class Solution {
    ArrayList<Integer>[] graph;
    Map<Integer, Integer>color;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        color = new HashMap<>();
        for(int i = 0; i <= N; i++)graph[i] = new ArrayList<>();
        
        for(int i = 0; i < dislikes.length; i++)
        {
            graph[dislikes[i][0]].add(dislikes[i][1]);
            graph[dislikes[i][1]].add(dislikes[i][0]);
        }
        for(int node = 1; node <= N; node++)
            if(!color.containsKey(node) && !dfs(node, 0))return false;
        return true;
    }
    public boolean dfs(int node, int c)
    {
        if(color.containsKey(node))return color.get(node) == c;
        color.put(node, c);
        
        for(int x: graph[node])
            if(!dfs(x, c^1))return false;
        return true;
    }
}

// we select the starting node of graph and color it. We then move to the nodes directly connected to the selected node and
// start coloring the node with the color opposite to the parent node. We repeat this process and if we encounter a node which has
// different color than it was supposed to be, then the graph cannot be bipartite.

// Time complexity: O(V+E) because we are traversing adjacency list only
// Auxilary Space complexity: O(V)

//https://practice.geeksforgeeks.org/problems/bipartite-graph/1
class GfG
{
    boolean isBipartite(int G[][],int V)
    {
        for(int i = 0; i < V; i++)
        {
            int[]color = new int[V];
            Arrays.fill(color, -1);
            if(!colorG(G, i, color, 1))return false;
        }
        return true;
    }
    boolean colorG(int[][]G, int idx, int[]color, int c){
        if(color[idx] != -1 && color[idx] == 1-c)return false;
        
        color[idx] = c;
        
        for(int i = 0; i < G[idx].length; i++){
            if(G[idx][i] == 0 || color[i] == 1-c)continue;
            if(!colorG(G, i, color, 1-c))return false;
        }
        return true;
    }
}
// Bipartite Graph: A graph which can be divided into two sets and the edges exits from either set 1 to set2 or set2 to set1

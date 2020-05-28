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

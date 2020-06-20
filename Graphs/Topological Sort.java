// What is topological Sort?

/* Example of a graph: 
 
                 5 --> 0 --> 4
                 |           |
                 v           v
                 2 --> 3 --> 1
                 
            1 is dependent on 3 and 4 (Therefore 1 should occur after 3 and 4)
            3 is dependent on 2 (Therefore 3 should occur after 2) and likewise  
*/
                 
class TopologicalSort {
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        
        Set<Integer>vis = new HashSet<>();
        Stack<Integer>stack = new Stack<>();
        
        for(int i = 0; i < N; i++)
            dfs(adj, vis, stack, i);
        
        int[] res = new int[N];
        int idx = 0;
        
        while(idx < res.length)res[idx++] = stack.pop();
        return res;
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj, Set<Integer>vis, Stack<Integer>stack, int node)
    {
        if(vis.contains(node))return;
        
        vis.add(node);
        
        for(int i = 0; i < adj.get(node).size(); i++)
            dfs(adj, vis, stack, adj.get(node).get(i));
        
        stack.push(node);
    }
}
// Time complexity: O(V+E) for traversing the adjacency list
// Auxiliary Space Complexity: O(V) for stack and the set

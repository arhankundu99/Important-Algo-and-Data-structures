// kosarajus algorithm helps us to find strongly connected components in a graph
// A strongly connected component is a component of graph in which every vertex is reachable by every other vertex in the strongly connected graph

// Steps involved:
// 1) Maintain a stack that contains the topological sort of graph
// 2) Reverse the adjacency list
// 3) initialise a visited array
// 4) while stack is not empty, do the following:
//    i) pop the element
//    ii) if the element is not visited, increase the count and do dfs

// references: https://www.youtube.com/watch?v=RpgcYiky7uw

class Solution
{
    Stack<Integer>stack;
    Map<Integer, Set<Integer>>map;
    public int kosaraju(ArrayList<ArrayList<Integer>> adj, int N)
    {
        stack = new Stack<>();
        map = new HashMap<>();
        boolean[] vis = new boolean[N];
        for(int i = 0; i < N; i++){
            if(!vis[i])topoSort(i, vis, adj);
        }
        reverse(adj);
        //System.out.println(map.get(3));
        
        int count = 0;
        
        vis = new boolean[N];
        while(!stack.isEmpty()){
            //System.out.print(stack.peek());
            if(vis[stack.peek()]){
                stack.pop();
                continue;
            }
            int u = stack.pop();
            //System.out.println(u);
            count++;
            dfs(u, vis);
            //for(int i = 0; i < N; i++)System.out.print(vis[i]+" ");
        }
        return count;
    }
    public void reverse(ArrayList<ArrayList<Integer>>adj){
        for(int i = 0; i < adj.size(); i++){
            for(int j: adj.get(i)){
                if(!map.containsKey(j))map.put(j, new HashSet<>());
                map.get(j).add(i);
            }
        }
    }
    public void dfs(int u, boolean[] vis){
        if(vis[u])return;
        vis[u] = true;
        if(map.containsKey(u)){
            for(int v: map.get(u)){
                dfs(v, vis);   
            }
        }
    }
    public void topoSort(int u, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        if(vis[u])return;
        
        vis[u] = true;
        for(int v: adj.get(u)){
            topoSort(v, vis, adj);
        }
        stack.push(u);
    }
}

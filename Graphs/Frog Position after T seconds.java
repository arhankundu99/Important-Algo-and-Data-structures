// https://leetcode.com/problems/frog-position-after-t-seconds/

class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        double[] prob = new double[n+1];
        boolean[] vis = new boolean[n+1];
        int[] time = new int[n+1];
        
        prob[1] = 1;
        vis[1] = true;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int i = 1; i <= n; i++)map.put(i, new HashSet<>());
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            
            map.get(u).add(v);
            map.get(v).add(u);
        }
        
        Queue<Integer>queue = new LinkedList<>();
        queue.add(1);
        
        while(queue.size() != 0){
            int u = queue.poll();
            
            if(map.containsKey(u)){
                for(int v: map.get(u)){
                    if(vis[v])continue;
                    vis[v] = true;
                    
                    if(u == 1)prob[v] = prob[u] / map.get(u).size();
                    else prob[v] = prob[u] / (map.get(u).size() - 1);
                    
                    time[v] = time[u] + 1;
                    queue.add(v);
                }
            }
        }
        if(time[target] > t)return 0;
        
        if(time[target] == t)return prob[target];
        
        if(target != 1){
            if(map.get(target).size() == 1)return prob[target];
            return 0;
        }
        else{
            if(map.get(target).size() == 0)return prob[target];
            return 0;
        }
        
    }
}

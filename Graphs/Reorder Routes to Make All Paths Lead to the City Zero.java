// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
class Solution {
    public int minReorder(int n, int[][] connections) {
        Set<String> set = new HashSet<>();
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++)map.put(i, new ArrayList<>());
        
        for(int[] c: connections){
            int from = c[0];
            int to = c[1];
            
            set.add(from + " " + to);
            
            map.get(from).add(to);
            map.get(to).add(from);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        boolean[] vis = new boolean[n];
        vis[0] = true;
        
        int count = 0;
        while(queue.size() != 0){
            int u = queue.poll();
            
            for(int v: map.get(u)){
                if(vis[v])continue;
                vis[v] = true;
                if(!set.contains(v + " " + u))count++;
                queue.add(v);
            }
        }
        return count;
    }
}

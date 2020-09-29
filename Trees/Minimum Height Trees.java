// https://leetcode.com/problems/minimum-height-trees/
class Solution {
    Map<Integer, Map<Integer, Integer>> dp;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        dp = new HashMap<>();
        
        for(int[] edge: edges){
            if(!map.containsKey(edge[0]))map.put(edge[0], new ArrayList<>());
            if(!map.containsKey(edge[1]))map.put(edge[1], new ArrayList<>());
            
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        Map<Integer, List<Integer>>hMap = new HashMap<>();
        
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int currDist = getDist(i, -1, map);
            
            if(!hMap.containsKey(currDist))hMap.put(currDist, new ArrayList<>());
            
            hMap.get(currDist).add(i);
            
            minDist = Math.min(minDist, currDist);
        }
        return hMap.get(minDist);
    }
    public int getDist(int x, int parent, Map<Integer, List<Integer>>map){
        int dist = 1;
        
        if(parent != -1 && dp.containsKey(x) && dp.get(x).containsKey(parent))return dp.get(x).get(parent);
        if(!dp.containsKey(x))dp.put(x, new HashMap<>());
        
        if(map.containsKey(x))
        for(int v: map.get(x)){
            if(v == parent)continue;
            dist = Math.max(dist, 1+getDist(v, x, map));
        }
        if(parent != -1)dp.get(x).put(parent, dist);
        return dist;
    }
}

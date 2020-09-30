https://leetcode.com/problems/network-delay-time/
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            
            if(!map.containsKey(u))map.put(u, new HashMap<>());
            
            map.get(u).put(v, w);
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, 10000000);
        
        dist[K] = 0;
        
        queue.add(new int[]{K, 0});
        
        while(queue.size() != 0){
            int[] poll = queue.poll();
            int u = poll[0];
            
            if(map.containsKey(u)){
                for(int v: map.get(u).keySet()){
                    if(dist[v] > dist[u] + map.get(u).get(v)){
                        dist[v] = dist[u] + map.get(u).get(v);
                        queue.add(new int[]{v, map.get(u).get(v)});
                    }
                }
            }
        }
        int delay = 0;
        for(int i = 1; i <= N; i++)delay = Math.max(delay, dist[i]);
        
        return delay >= 10000000? -1: delay;
    }
}

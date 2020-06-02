//leetcode prob no 1311
//Difficulty: Medium
//Bellman-ford algorithm is used
class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int[]dist = new int[friends.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Map<String, Integer> map = new HashMap<>();
        List<String>list = new ArrayList<>();
        
        int src = id;
        
        dist[src] = 0;
        
        for(int i=0;i<dist.length-1;i++)
        {
            for(int j=0;j<friends.length;j++)
            {
                int u = j;
                for(int k=0;k<friends[j].length;k++)
                {
                    int v = friends[j][k];
                    
                    if(dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + 1)
                        dist[v] = dist[u]+1;
                }
            }
        }
        for(int i=0;i<dist.length;i++)
        {
            if(dist[i] == level)
            {
                for(String video: watchedVideos.get(i))
                {
                    if(!map.containsKey(video))map.put(video, 1);
                    else map.put(video, map.get(video)+1);
                }
            }
        }
        PriorityQueue<String>queue = new PriorityQueue<>(new Comparator<>(){
            public int compare(String a, String b)
            {
                if(map.get(a) == map.get(b))return a.compareTo(b);
                return map.get(a)-map.get(b);
            }
        });
        
        for(String key: map.keySet())queue.add(key);
        
        while(queue.size() != 0)list.add(queue.poll());
        
        return list;
    }
}

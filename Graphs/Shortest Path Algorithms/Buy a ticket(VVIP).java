// https://codeforces.com/contest/938/problem/D
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int m = scan.nextInt();
        
        PriorityQueue<pair> queue = new PriorityQueue<>(new Comparator<pair>(){
            public int compare(pair a, pair b){
                return Long.compare(a.dist, b.dist);
            }   
        });
        Map<Integer, Map<Integer, Long>> map = new HashMap<>();
        
        for(int i = 0; i < m; i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            long w = scan.nextLong();
            
            if(!map.containsKey(u-1))map.put(u-1, new HashMap<>());
            if(!map.containsKey(v-1))map.put(v-1, new HashMap<>());
            
            map.get(u-1).put(v-1, 2*w);
            map.get(v-1).put(u-1, 2*w);
        }
        
        long[] cost = new long[n];
        
        for(int i = 0; i < n; i++){
            cost[i] = scan.nextLong();
        }
        
        for(int i = 0; i < n; i++){
            queue.add(new pair(i, cost[i]));
        }
        boolean[] vis = new boolean[n];
        while(queue.size() != 0){
            pair poll = queue.poll();
            int u = poll.node;
            
            if(vis[u])continue;
            vis[u] = true;
            
            if(map.containsKey(u)){
                for(int v: map.get(u).keySet()){
                    long w = map.get(u).get(v);
                    if(cost[v] > cost[u] + w){
                        //means person in v should go to u
                        cost[v] = cost[u] + w;
                        queue.add(new pair(v, cost[v]));
                    }
                }
            }
        }
        for(int i = 0; i < n; i++)System.out.print(cost[i]+" ");
    }
}
class pair{
    int node;
    long dist;
    pair(int node, long dist){
        this.node = node;
        this.dist = dist;
    }
    
}

//leetcode prob number 787
//Difficulty: Medium
//Bellman-ford algorithm is used
//There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
//Now given all the cities and flights, together with starting city src and the destination dst, 
//your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        int[]cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        cost[src] = 0;
        
        for(int i = 0; i <= K; i++)
        {
            int[] temp = Arrays.copyOf(cost, n);
            for(int j=0;j<flights.length;j++)
            {
                int u = flights[j][0];
                int v = flights[j][1];
                int w = flights[j][2];
                
                if(cost[u] != Integer.MAX_VALUE && temp[v] > cost[u] + w)
                    temp[v] = cost[u] + w;
            }
            cost = temp;
        }
        return cost[dst] != Integer.MAX_VALUE? cost[dst]: -1;
    }
}

// leetcode prob number 1334
// Floyd Warshall algorithm is used.

class Solution {
    public int findTheCity(int n, int[][] edges, int thresold) {
        int[][]dist = new int[n][n];
        int max = 100000;
        int ans = -1, minCities = max;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)dist[i][j] = max;
            dist[i][i] = 0;
        }

        for(int i=0;i<edges.length;i++)
        {
            dist[edges[i][0]][edges[i][1]] = edges[i][2];
            dist[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        
        Map<Integer, Set<Integer>>map = new HashMap<>();
        for(int i=0;i<n;i++)map.put(i, new HashSet<>());
        
        for(int k=0;k<n;k++)
        {    
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dist[i][j] > dist[i][k]+dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                    if(dist[i][j] <= thresold)map.get(i).add(j);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(map.get(i).size() <= minCities)
            {
                minCities = map.get(i).size();
                ans = i;
            }
        }
        return ans;
    }
}

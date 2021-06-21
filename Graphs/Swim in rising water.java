// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3785/
// (This ques can also be solved using dijkstra)

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = 0, high = n * n - 1;
        int time = -1;
        
        while(low <= high){
            
            int mid = (low + high) / 2;
            
            int[][] dist = new int[n][n];
            boolean[][] vis = new boolean[n][n];
            
            for(int i = 0; i < n; i++)Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[0][0] = 0;
            
            Queue<int[]> queue = new LinkedList();
            queue.add(new int[]{0, 0});
            
            int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            
            while(queue.size() != 0){
                int[] poll = queue.poll();
                
                if(vis[poll[0]][poll[1]])continue;
                vis[poll[0]][poll[1]] = true;
                
                for(int[] move: moves){
                    int newX = poll[0] + move[0];
                    int newY = poll[1] + move[1];
                    
                    if(newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] <= mid && grid[poll[0]][poll[1]] <= mid && dist[newX][newY] != 0){
                        
                        queue.add(new int[]{newX, newY});
                        dist[newX][newY] = 0;
                    }
                }
                
            }
            if(dist[n - 1][n - 1] == 0){
                time = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return time;
    }
}

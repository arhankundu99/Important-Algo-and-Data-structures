// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3785/
class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });
        
        queue.add(new int[]{0, 0, grid[0][0]});
        int[][] dist = new int[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++)Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(queue.size() != 0){
            int[] poll = queue.poll();
            
            for(int[] move: moves){
                int newR = poll[0] + move[0];
                int newC = poll[1] + move[1];
                int currT = poll[2];
                
                if(newR >= 0 && newR < grid.length && newC >= 0 && newC < grid.length){
                    int newT = currT + Math.max(0, grid[newR][newC] - currT);
                    
                    if(dist[newR][newC] > newT){
                        dist[newR][newC] = newT;
                        queue.add(new int[]{newR, newC, newT});
                    }
                }
            }
        }
        return dist[grid.length - 1][grid.length - 1];
    }
}

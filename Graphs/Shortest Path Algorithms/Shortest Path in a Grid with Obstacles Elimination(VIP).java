//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3987/
class Solution {
    public int shortestPath(int[][] grid, int k) {
        if(grid.length == 0)return 0;
        if(grid.length == 1 && grid[0].length == 1)return 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        
        int[][][] dist = new int[grid.length][grid[0].length][k + 1];
        
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
        
        for(int i = 0; i <= k; i++)dist[0][0][i] = 0;
        int min = Integer.MAX_VALUE;
        while(queue.size() != 0){
            int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            
            int[] poll = queue.poll();
            
            for(int[] move: moves){
                int moveX = poll[0] + move[0];
                int moveY = poll[1] + move[1];
                int currK = poll[2];
                
                if(!isValid(moveX, moveY, grid.length, grid[0].length))continue;
                if(grid[moveX][moveY] == 1){
                    if(currK == k)continue;
                    if(dist[moveX][moveY][currK + 1] > dist[poll[0]][poll[1]][currK] + 1){
                        dist[moveX][moveY][currK + 1] = dist[poll[0]][poll[1]][currK] + 1;
                        queue.add(new int[]{moveX, moveY, currK + 1});
                        if(moveX == grid.length - 1 && moveY == grid[0].length - 1)min = Math.min(min, dist[moveX][moveY][currK + 1]);
                    }
                }
                    
                else{
                    if(dist[moveX][moveY][currK] > dist[poll[0]][poll[1]][currK] + 1){
                        dist[moveX][moveY][currK] = dist[poll[0]][poll[1]][currK] + 1;
                        queue.add(new int[]{moveX, moveY, currK});
                        if(moveX == grid.length - 1 && moveY == grid[0].length - 1)min = Math.min(min, dist[moveX][moveY][currK]);
                    }
                }
            }
        }
        //print(dist);

        return min == Integer.MAX_VALUE? -1: min;
    }
    public boolean isValid(int r, int c, int tr, int tc){
        if(r < 0 || c < 0 || r == tr || c == tc)return false;
        return true;
    }
    public void print(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

//Uses multi-source BFS
//Note that I did not use visited array
//Difficulty: Medium
//https://leetcode.com/problems/01-matrix/
//Concept learnt: Use multi-source bfs when you need to find shortest distances for all elements

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]>queue = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0)
                    queue.add(new int[]{i, j});
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(matrix, queue);
        return matrix;
    }
    public void bfs(int[][] matrix, Queue<int[]>queue){
        
        int[][] movements = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while(queue.size() != 0){
            int[] poll = queue.poll();
            for(int[] movement: movements){
                int r2 = poll[0] + movement[0];
                int c2 = poll[1] + movement[1];
                
                if(r2 < 0 || c2 < 0 || r2 == matrix.length || c2 == matrix[0].length || matrix[r2][c2] < matrix[poll[0]][poll[1]]+1)continue;
                
                matrix[r2][c2] = matrix[poll[0]][poll[1]] + 1;
                
                queue.add(new int[]{r2, c2});
            }
        }
    }
}

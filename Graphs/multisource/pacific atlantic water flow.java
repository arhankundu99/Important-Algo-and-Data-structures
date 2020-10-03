// https://leetcode.com/problems/pacific-atlantic-water-flow/
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        
        if(matrix.length == 0)return new ArrayList<>();
        
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        
        
        Queue<int[]>queue = new LinkedList<>();
        
        for(int i = 0; i < matrix[0].length; i++){
            pacific[0][i] = true;
            queue.add(new int[]{0, i});
        }
        for(int i = 1; i < matrix.length; i++){
            pacific[i][0] = true;
            queue.add(new int[]{i, 0});
        }
        bfs(matrix, queue, vis, pacific);
        
        queue = new LinkedList<>();
        vis = new boolean[matrix.length][matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++){
            queue.add(new int[]{i, matrix[0].length-1});
            atlantic[i][matrix[0].length-1] = true;
        }
        
        for(int i = 0; i < matrix[0].length-1; i++){
            queue.add(new int[]{matrix.length-1, i});
            atlantic[matrix.length-1][i] = true;
        }
        bfs(matrix, queue, vis, atlantic);
        
        List<List<Integer>>list = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
        return list;
    }
    public void bfs(int[][] matrix, Queue<int[]>queue, boolean[][] vis, boolean[][] isReachable){
        
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(queue.size() != 0){
            int[]poll = queue.poll();
            int r = poll[0], c = poll[1];
            
            if(vis[r][c])continue;
            vis[r][c] = true;
            
            for(int[] move: moves){
                int r2 = r + move[0];
                int c2 = c + move[1];
                
                if(r2 == matrix.length || r2 < 0 || c2 == matrix[0].length || c2 < 0 || matrix[r][c] > matrix[r2][c2] || vis[r2][c2])continue;
                
                isReachable[r2][c2] = true;
                queue.add(new int[]{r2, c2});
            }
        }
    }
}

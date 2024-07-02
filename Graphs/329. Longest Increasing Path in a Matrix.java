// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

public int longestIncreasingPath(int[][] matrix) {
    if(matrix.length == 0) return 0;
    int m = matrix.length, n = matrix[0].length;
    int[][] cache = new int[m][n];
    int max = 1;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            int len = dfs(matrix, i, j, m, n, cache);
            max = Math.max(max, len);
        }
    }   
    return max;
}

public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
    if(cache[i][j] != 0) return cache[i][j];
    int max = 1;
    for(int[] dir: dirs) {
        int x = i + dir[0], y = j + dir[1];
        if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
        int len = 1 + dfs(matrix, x, y, m, n, cache);
        max = Math.max(max, len);
    }
    cache[i][j] = max;
    return max;
}

// Using BFS
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        Queue<int[]> queue = new LinkedList<>();
        
        int[][] dist = new int[matrix.length][matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++)
            Arrays.fill(dist[i], 0);
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                queue.add(new int[]{i, j});
            }
        }
        int maxDist = 1;
        
        while(queue.size() != 0){
            int[] poll = queue.poll();
            
            for(int[] move: moves){
                int r = poll[0] + move[0];
                int c = poll[1] + move[1];
                
                if(isValid(matrix, r, c)){
                    if(matrix[r][c] > matrix[poll[0]][poll[1]] && dist[r][c] < dist[poll[0]][poll[1]] + 1){

                        dist[r][c] = dist[poll[0]][poll[1]] + 1;
                        maxDist = Math.max(maxDist, dist[r][c] + 1);
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        return maxDist;
    }
    
    public boolean isValid(int[][] matrix, int r, int c){
        if(r < 0 || c < 0 || r == matrix.length || c == matrix[0].length)return false;
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

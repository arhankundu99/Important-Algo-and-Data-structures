// https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3835/
class Solution {

    public int largestIsland(int[][] grid) {

        int idx = 2;

        int maxSize = 0;

        Map<Integer, Integer> map = new HashMap<>();

        boolean[][] vis = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid.length; j++){

                int max = dfs(grid, i, j, idx, vis);

                map.put(idx, max);

                maxSize = Math.max(maxSize, max);

                idx++;

            }

        }

        

        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 0){

                    int size = 1;

                    Set<Integer> set = new HashSet<>();

                    if(i - 1 >= 0 && grid[i - 1][j] != 0){

                        set.add(grid[i - 1][j]);

                        size += map.get(grid[i - 1][j]);

                    }

                    if(i + 1 < grid.length && grid[i + 1][j] != 0){

                        if(!set.contains(grid[i + 1][j])){

                            set.add(grid[i + 1][j]);

                            size += map.get(grid[i + 1][j]);

                        }

                    }

                    if(j - 1 >= 0 && grid[i][j - 1] != 0){

                        if(!set.contains(grid[i][j - 1])){

                            set.add(grid[i][j - 1]);

                            size += map.get(grid[i][j - 1]);

                        }

                    }

                    if(j + 1 < grid[0].length && grid[i][j + 1] != 0){

                        if(!set.contains(grid[i][j + 1])){

                            set.add(grid[i][j + 1]);

                            size += map.get(grid[i][j + 1]);

                        }

                    }

                    maxSize = Math.max(maxSize, size);

                }

            }

        }

        return maxSize;

    }

    public int dfs(int[][] grid, int r, int c, int idx, boolean[][] vis){

        if(r == grid.length || c == grid[0].length || r < 0 || c < 0 || vis[r][c] || grid[r][c] == 0)return 0;

        grid[r][c] = idx;

        vis[r][c] = true;

        

        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        

        int size = 1;

        for(int[] move: moves){

            size += dfs(grid, r + move[0], c + move[1], idx, vis);

        }

        return size;

    }

}

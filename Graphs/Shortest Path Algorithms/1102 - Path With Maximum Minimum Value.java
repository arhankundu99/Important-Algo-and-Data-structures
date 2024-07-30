// https://leetcode.ca/2018-12-06-1102-Path-With-Maximum-Minimum-Value/
// Given an m x n integer matrix grid, return the maximum score of a path starting at (0, 0) and ending at (m - 1, n - 1) moving in the 4 cardinal directions.

// The score of a path is the minimum value in that path.

// For example, the score of the path 8 → 4 → 5 → 9 is 4.

class Solution {
    int [][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
      public int maximumMinimumPath(int[][] A) {
          int m = A.length;
          int n = A[0].length;
  
          PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> b[2] - a[2]);
          maxHeap.add(new int[]{0, 0, A[0][0]});
          boolean [][] visited = new boolean[m][n];
          visited[0][0] = true;
  
          int res = A[0][0];
          while (!maxHeap.isEmpty()) {
              int[] cur = maxHeap.poll();
  
              res = Math.min(res, cur[2]);
              if (cur[0] == m - 1 && cur[1] == n - 1) {
                  return res;
              }
  
              for (int [] dir : dirs) {
                  int x = cur[0] + dir[0];
                  int y = cur[1] + dir[1];
                  if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                      continue;
                  }
  
                  visited[x][y] = true;
                  maxHeap.add(new int[]{x, y, A[x][y]});
              }
          }
  
          return res;
      }
  
  }
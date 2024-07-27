// https://leetcode.ca/all/305.html
import java.util.*;

class DSU {
    int[] parent;
    int[] size;
    DSU (int n) {
        this.parent = new int[n];
        this.size = new int[n];
        
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    boolean union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        
        if (xParent == yParent) {
            return false;
        }
        
        if (size[xParent] > size[yParent]) {
            parent[yParent] = xParent;
            size[xParent] += size[yParent];
        } else {
            parent[xParent] = yParent;
            size[yParent] += size[xParent];
        }
        return true;
    }
}

class Solution {
    int[] getNumIslandsAfterOperations(int M, int N, int[][] positions) {
        int[][] grid = new int[M][N];
        
        int count = 0;
        DSU dsu = new DSU(M * N);
        int[] islands = new int[positions.length];
        
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < positions.length; i++) {
            int currCell = positions[i][0] * M + positions[i][1];
            if (grid[positions[i][0]][positions[i][1]] == 1) {
                islands[i] = count;
                continue;
            }
            count++;

            grid[positions[i][0]][positions[i][1]] = 1;
            
            for (int[] move: moves) {
                int nextR = positions[i][0] + move[0];
                int nextC = positions[i][1] + move[1];
                
                if (nextR >= 0 && nextR < M && nextC >= 0 && nextC < N && grid[nextR][nextC] == 1) {
                    int nextCell = nextR * M + nextC;
                    if (dsu.union(currCell, nextCell)) {
                        count--;
                    }
                }
            }
            islands[i] = count;
        }
        return islands;
    }
}

public class Main {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] positions = new int[][]{{0,0}, {0,1}, {1,2}, {2,1}};
        
        int[] islands = (new Solution()).getNumIslandsAfterOperations(m, n, positions);
        for (int i = 0; i < islands.length; i++) {
            System.out.print(islands[i] + " ");
        }
        System.out.println();
    }
}
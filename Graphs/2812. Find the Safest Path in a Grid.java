// https://leetcode.com/problems/find-the-safest-path-in-a-grid/
class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        // Do a multi source bfs and find the distance of each grid cell from the closest thief
        // Now get the maximum distance and minimum distance of a cell from the thief
        // Do a binary search with minimum and maximum distance and check if a path is possible with the given distance using bfs

        Queue<int[]> queue = new LinkedList<>();
        int[][] distFromTheives = new int[grid.size()][grid.get(0).size()];

        for (int i = 0; i < grid.size(); i++) {
            Arrays.fill(distFromTheives[i], Integer.MAX_VALUE);
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.add(new int[]{i, j});
                    distFromTheives[i][j] = 0;
                }
            }
        }

        
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (queue.size() != 0) {
            int[] currCell = queue.poll();

            for (int[] move: moves) {
                int nextRow = currCell[0] + move[0];
                int nextCol = currCell[1] + move[1];

                if (nextRow >= 0 && nextRow < grid.size() && nextCol >= 0 && nextCol < grid.get(0).size() && distFromTheives[nextRow][nextCol] > distFromTheives[currCell[0]][currCell[1]] + 1) {
                    distFromTheives[nextRow][nextCol] = distFromTheives[currCell[0]][currCell[1]] + 1;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }

        int minDistance = Integer.MAX_VALUE, maxDistance = 0;
        for (int i = 0; i < distFromTheives.length; i++) {
            for (int j = 0; j < distFromTheives[0].length; j++) {
                minDistance = Math.min(distFromTheives[i][j], minDistance);
                maxDistance = Math.max(distFromTheives[i][j], maxDistance);
            }
        }

        // print(distFromTheives);

        int low = minDistance, high = maxDistance;

        int maxSafenessFactor = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // System.out.println(mid);
            if (canTraverse(distFromTheives, mid)) {
                maxSafenessFactor = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return maxSafenessFactor;
    }

    private boolean canTraverse(int[][] distFromTheives, int distance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[distFromTheives.length][distFromTheives[0].length];
        visited[0][0] = true;
        int minDistance = distFromTheives[0][0];

        if (minDistance < distance) {
            return false;
        }

        int destRow = distFromTheives.length - 1, destCol = distFromTheives[0].length - 1;


        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (queue.size() != 0) {
            int[] currCell = queue.poll();
            if (currCell[0] == destRow && currCell[1] == destCol) {
                return true;
            }

             for (int[] move: moves) {
                int nextRow = currCell[0] + move[0];
                int nextCol = currCell[1] + move[1];

                if (nextRow >= 0 && nextRow < distFromTheives.length && nextCol >= 0 && nextCol < distFromTheives[0].length && !visited[nextRow][nextCol] && distFromTheives[nextRow][nextCol] >= distance) {
                    queue.add(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
        return false;
    }

    private void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
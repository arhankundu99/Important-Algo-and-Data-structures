// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();

        int idx = 0;
        for (int[] stone: stones) {
            if (!rowMap.containsKey(stone[0])) {
                rowMap.put(stone[0], new HashSet<>());
            }

            if (!colMap.containsKey(stone[1])) {
                colMap.put(stone[1], new HashSet<>());
            }
            rowMap.get(stone[0]).add(idx);
            colMap.get(stone[1]).add(idx);
            idx++;
        }

        boolean[] visited = new boolean[stones.length];
        int count = 0;

        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(rowMap, colMap, stones, i, visited);
            }
        }
        return stones.length - count;
    }

    private void dfs(Map<Integer, Set<Integer>> rowMap, Map<Integer, Set<Integer>> colMap, int[][] stones, int currIdx, boolean[] visited) {
        if (visited[currIdx]) {
            return;
        }
        visited[currIdx] = true;
        if (rowMap.containsKey(stones[currIdx][0])) {
            for (int idx: rowMap.get(stones[currIdx][0])) {
                dfs(rowMap, colMap, stones, idx, visited);
            }
        }
        if (colMap.containsKey(stones[currIdx][1])) {
            for (int idx: colMap.get(stones[currIdx][1])) {
                dfs(rowMap, colMap, stones, idx, visited);
            }
        }
    }
}


// With DSU
class Solution {
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU(stones.length);
        for(int i = 0; i < stones.length; i++){
            for(int j = i + 1; j < stones.length; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    dsu.union(i, j);
                }
            }
        }
        return stones.length - dsu.getNumSets();

    }
}

class DSU {
    private int[] parent;
    private int[] size;
    private int numSets;

    DSU (int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        numSets = n;
    }

    void union (int u, int v) {
        int parentU = find(u);
        int parentV = find(v);

        if (parentU == parentV) {
            return;
        }

        if (size[parentU] > size[parentV]) {
            parent[parentV] = parentU;
        } else {
            parent[parentU] = parentV;
        }
        numSets--;
    }

    int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u]);
    }

    int getNumSets() {
        return numSets;
    }
}
// https://leetcode.com/problems/critical-connections-in-a-network/

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Set<Pair<Integer, Integer>> criticalConnections = new HashSet<>();
        Map<Integer, Set<Integer>> adjMap = new HashMap<>();
        for (List<Integer> connection: connections) {
            int u = connection.get(0);
            int v = connection.get(1);

            criticalConnections.add(new Pair<Integer, Integer>(Math.min(u, v), Math.max(u, v)));
            
            if (!adjMap.containsKey(u)) {
                adjMap.put(u, new HashSet<>());
            }

            if (!adjMap.containsKey(v)) {
                adjMap.put(v, new HashSet<>());
            }

            adjMap.get(u).add(v);
            adjMap.get(v).add(u);
        }

        dfs(adjMap, 0, -1, 0, criticalConnections, new HashMap<Integer, Integer>());
        List<List<Integer>> result = new ArrayList<>();

        for (Pair<Integer, Integer> criticalConnection: criticalConnections) {
            result.add(new ArrayList<>());
            result.get(result.size() - 1).add(criticalConnection.getKey());
            result.get(result.size() - 1).add(criticalConnection.getValue());
        }
        return result;
    }

    private int dfs(Map<Integer, Set<Integer>> adjMap, int currentNode, int parentNode, int currentRank, Set<Pair<Integer, Integer>> criticalConnections, Map<Integer, Integer> rankMap) {
        if (rankMap.containsKey(currentNode)) {
            return rankMap.get(currentNode);
        }
        rankMap.put(currentNode, currentRank);
        int minRank = currentRank;

        if (adjMap.containsKey(currentNode)) {
            for (int nextNode: adjMap.get(currentNode)) {
                if (nextNode == parentNode) {
                    continue;
                }
                int rank = dfs(adjMap, nextNode, currentNode, currentRank + 1, criticalConnections, rankMap);
                if (currentRank >= rank) {
                    criticalConnections.remove(new Pair<Integer, Integer>(Math.min(currentNode, nextNode), Math.max(currentNode, nextNode)));
                }
                minRank = Math.min(minRank, rank);
            }
        }
        return minRank;
    }
}

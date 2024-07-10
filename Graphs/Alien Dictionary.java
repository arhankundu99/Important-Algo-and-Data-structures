// https://leetcode.ca/2016-08-25-269-Alien-Dictionary/
public class Solution {
    // dfs
    public String alienOrder(String[] words) {

        // Step 1: build the graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            for (int j = 0; j < currentWord.length(); j++) {
                if (!graph.containsKey(currentWord.charAt(j))) {
                    graph.put(currentWord.charAt(j), new HashSet<>());
                }
            }

            if (i > 0) {
                connectGraph(graph, words[i - 1], currentWord);
            }
        }

        // Step 2: topological sorting
        StringBuffer sb = new StringBuffer();
        Map<Character, Integer> visited = new HashMap<Character, Integer>(); // mark as visited: visited.put(vertexId, -1);

        for (Map.Entry<Character, Set<Character>> entry: graph.entrySet()) {
            char vertexId = entry.getKey();
            if (!topologicalSort(vertexId, graph, sb, visited)) {
                return "";
            }
        }

        return sb.toString();
    }

    private void connectGraph(Map<Character, Set<Character>> graph, String prev, String curr) {
        if (prev == null || curr == null) {
            return;
        }

        int len = Math.min(prev.length(), curr.length());

        for (int i = 0; i < len; i++) {
            char p = prev.charAt(i);
            char q = curr.charAt(i);
            if (p != q) { // so if same duplicated work, will not reach here and not update graph
                if (!graph.get(p).contains(q)) {
                    graph.get(p).add(q);
                }
                break;
            }
        }
    }

    private boolean topologicalSort(
        char vertexId,
        Map<Character, Set<Character>> graph,
        StringBuffer sb,
        Map<Character, Integer> visited
    ) {

        if (visited.containsKey(vertexId)) {
            // visited
            if (visited.get(vertexId) == -1) { // -1 meaning visited, cycle found
                return false;
            }

            // already in the list
            if (visited.get(vertexId) == 1) {
                return true;
            }
        }

        visited.put(vertexId, -1); // mark as visited


        Set<Character> neighbors = graph.get(vertexId);
        for (char neighbor : neighbors) {
            if (!topologicalSort(neighbor, graph, sb, visited)) {
                return false;
            }
        }

        sb.insert(0, vertexId);
        visited.put(vertexId, 1); // restore visited

        return true;
    }
}
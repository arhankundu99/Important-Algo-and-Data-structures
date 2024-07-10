// https://leetcode.com/problems/maximum-score-of-a-node-sequence/solutions/1953706/java-python-keep-3-biggest-neighbours/
class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        PriorityQueue<Integer>[] pq = new PriorityQueue[scores.length];

        for (int i = 0; i < scores.length; i++) {
            pq[i] = new PriorityQueue<>(new Comparator<Integer>() {
                public int compare(Integer node1, Integer node2) {
                    return scores[node1] - scores[node2];
                }
            });
        }

        for (int[] edge: edges) {
            int u = edge[0], v = edge[1];

            pq[u].add(v);
            pq[v].add(u);

            if (pq[u].size() > 3) {
                pq[u].poll();
            }

            if (pq[v].size() > 3) {
                pq[v].poll();
            }
        }

        int maxScore = -1;
        for (int[] edge: edges) {
            for (int i: pq[edge[0]]) {
                for (int j: pq[edge[1]]) {
                    if (i != j && i != edge[1] && j != edge[0]) {
                        maxScore = Math.max(maxScore, scores[i] + scores[j] + scores[edge[0]] + scores[edge[1]]);
                    }
                }
            }
        }
        return maxScore;
    }
}
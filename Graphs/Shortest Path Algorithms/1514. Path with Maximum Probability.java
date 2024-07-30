// https://leetcode.com/problems/path-with-maximum-probability/
// Note the use of maxheap here. We can use max heap because the probability decreases after each node.
// A standard setup for Dijkstra's algorithm is as follows:

// We have a graph with weighted, non-negative edges (usually directed).
// The cost of a route is computed by summing up the weights along the route
// We are interested in finding the routes with minimal cost from a source node.
// In this question, however, we have quite a different setup:

// The cost of the route is determined by multiplying the weights along the route, instead of a summation.
// We are interested in finding the routes that have maximal cost rather than minimal.
// The weights are between 0 and 1, as they represent probabilities.
// How do we know Dijkstra's algorithm is applicable to this problem?

// Many solutions here are using a slightly modified version of Dijkstra's algorithm, by using a) MaxHeap instead of MinHeap data structure (or, equivalently, putting negative probability values as keys in a min heap) and b) computing the cost of the path by multiplication, rather than summation. These modifications are not immediately trivial. Is the resulting solution still considered as an application of Dijkstra's algorithm? How do we prove its correctness? Does it have the same time complexity?

// Let's have a different perspective on what we need the next item that we pop from the queue to be like:
// It has to be the node that we can not improve the cost of getting to this node on a different path. For the original algorithm, it is the node that is closest to the source, and, since there are no negative edges in the graph, we are confident that we can not improve on this cost. In the modified version, the next node is one with the highest probability that we know so far. Is there a chance to improve on this probability from another route? No! Because all the weights are probabilities and are in the range [0,1]. Multiplying by such number will never give a better probability.
// So, the key point here is: the requirement of non negative weights in the original setup is equivalent to a requirement of weights in range [0,1] for this question.

// How about multiplication vs summation? The key point is the observation that for the algorithm to work, we need the routes to get monotonically "worse" after every hop. For the original setup, every hop adds to the cost of the route (or it stays the same if w=0) and by going further the route gets more expensive, so we aim to find cheaper (shorter) routes. In the modified version, every hop decreases the probability (or it stays the same if p=1) and by going further the route gets more expensive, so we aim to find cheaper (more probable) routes.
// So, the key point here is: the summation of non-negative weights in the original setup is equivalent to a multiplication of probabilities in this question, because both operations maintain the monotonic nature of routes getting more expensive as we go.

// These 2 points show the equivalency between this question and the standard shortest paths problem. By having the weights constrained between [0, 1], by using multiplication instead of summation, and by utilizing MaxHeap instead of MinHeap, we can use the modified Dijkstra's algorithm and have the same time complexity of O(ElogV)
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            double w = succProb[i];

            if(!map.containsKey(u)){
                map.put(u, new HashMap<>());
            }

            if(!map.containsKey(v)){
                map.put(v, new HashMap<>());
            }

            map.get(u).put(v, w);
            map.get(v).put(u, w);
        }

        double[] prob = new double[n];
        Arrays.fill(prob, -1);
        prob[start] = 1;
        PriorityQueue<double[]> queue = new PriorityQueue<>(new Comparator<double[]>() {
            public int compare(double[] edge1, double[] edge2) {
                if (edge2[1] > edge1[1]) {
                    return 1;
                } else if (edge2[1] == edge1[1]) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        queue.add(new double[]{start, 1});

        while(queue.size() != 0){
            double[] u = queue.poll();
            int src = (int)u[0];
            if(map.containsKey(src)){
                for(int v: map.get(src).keySet()){
                    double w = map.get(src).get(v);
                    if(prob[v] == -1 || prob[v] < prob[src] * w){
                        prob[v] = prob[src] * w;
                        queue.add(new double[]{v, prob[v]});
                    }
                }
            }
        }


        return prob[end] == -1? 0: prob[end];
    }
}
//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3972/
class Solution {

    public int reachableNodes(int[][] edges, int maxMoves, int n) {

        //PriorityQueue for dijkstra algorithm

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<>(){

            public int compare(int[] a, int[] b){

                return a[1] - b[1];

            }

        });

        

        //adjacency map

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        

        for(int[] edge: edges){

            int u = edge[0];

            int v = edge[1];

            int w = edge[2] + 1; //number of nodes between u and v is edge[2], therefore dist(u, v) = edge[2] + 1

            

            if(!map.containsKey(u))map.put(u, new HashMap<>());

            if(!map.containsKey(v))map.put(v, new HashMap<>());

            

            map.get(u).put(v, w);

            map.get(v).put(u, w);

        }

        

        //dist[i] represents the distance between node 0 and node i

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        

        dist[0] = 0; // 0 is the source node

        

        queue.add(new int[]{0, 0});

        

        //calculating distances using dijkstra algorithm

        while(queue.size() != 0){

            int u = queue.poll()[0];

            

            if(map.containsKey(u)){

                for(int v: map.get(u).keySet()){

                    

                    int w = map.get(u).get(v);

                    

                    if(dist[v] > dist[u] + w){

                        dist[v] = dist[u] + w;

                        queue.add(new int[]{v, dist[v]});

                    }

                }

            }

        }

        

        int count = 0; //count represents the number of nodes that have distance from node 0 <= maxMoves

        

        for(int u: map.keySet()){

            

            //if there is no path between 0 to u

            if(dist[u] == Integer.MAX_VALUE)continue;

            for(int v: map.get(u).keySet()){

                

                //if there is no path between 0 to v

                if(dist[v] == Integer.MAX_VALUE)continue;

                

                //nodes between u and v

                int nodesBetweenUV = map.get(u).get(v) - 1;

                

                //number of nodes covered from u and v

                int nodesCovered = 0;

                

                if(nodesBetweenUV + dist[u] <= maxMoves || nodesBetweenUV + dist[v] <= maxMoves){

                    nodesCovered = nodesBetweenUV;

                }

                

                else{

                    int nodesLeftForU = maxMoves - dist[u];

                    

                    if(nodesLeftForU > 0){

                        nodesCovered += Math.min(nodesLeftForU, nodesBetweenUV);

                    }

                    

                    int nodesLeftForV = nodesBetweenUV - Math.min(nodesLeftForU, nodesBetweenUV);

                    

                    if(nodesLeftForV > 0){

                        nodesCovered += Math.max(0, Math.min(maxMoves - dist[v], nodesLeftForV));

                    }

                }

                //System.out.println(u + " " + v + " " + nodesCovered);

                count += nodesCovered;

            }

        }

        //System.out.println("....................");

        

        //The covered nodes are being counted twice as it is a bidirected graph

        count /= 2;

        

        //counting the nodes of the original graph

        for(int d: dist){

            //System.out.print(d + " ");

            if(d <= maxMoves)count++;

        }

        return count;

    }

}

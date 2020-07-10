//https://www.interviewbit.com/problems/clone-graph/
//bfs solution
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        queue.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        while(queue.size() != 0){
            UndirectedGraphNode u = queue.poll();
            for(UndirectedGraphNode v: u.neighbors){
                UndirectedGraphNode vC = map.get(v);
                if(vC == null){
                    vC = new UndirectedGraphNode(v.label);
                    map.put(v, vC);
                    queue.add(v);
                }
                map.get(u).neighbors.add(vC);
            }
        }
        return map.get(node);
    }
}

//dfs solution
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Set<UndirectedGraphNode>set = new HashSet<>();
        
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        cloneGraph(node, copyNode, map, set);
        return copyNode;
    }
    public void cloneGraph(UndirectedGraphNode node, UndirectedGraphNode copyNode, Map<UndirectedGraphNode, UndirectedGraphNode> map, Set<UndirectedGraphNode> set){
        map.put(node, copyNode);
        set.add(node);
        for(UndirectedGraphNode neighbor: node.neighbors){
            if(map.containsKey(neighbor))
                copyNode.neighbors.add(map.get(neighbor));
            else{
                copyNode.neighbors.add(new UndirectedGraphNode(neighbor.label));
                map.put(neighbor, copyNode.neighbors.get(copyNode.neighbors.size()-1));
            }
        }
        for(int i = 0; i < node.neighbors.size(); i++){
            if(set.contains(node.neighbors.get(i)))continue;
            cloneGraph(node.neighbors.get(i), copyNode.neighbors.get(i), map, set);
        }
    }
}

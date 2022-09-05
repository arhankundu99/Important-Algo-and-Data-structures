// https://leetcode.com/problems/n-ary-tree-level-order-traversal/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.size() != 0){
            int size = queue.size();
            list.add(new ArrayList<>());
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                for(Node child: node.children){
                    queue.add(child);
                }
                list.get(list.size() - 1).add(node.val);
            }
        }
        
        return list;
    }
}

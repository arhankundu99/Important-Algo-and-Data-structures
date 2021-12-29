//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
 
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Map<Integer, Node> map;
    public Node connect(Node root) {
        map = new HashMap<>();
        dfs(root, 0);
        return root;
    }
    public void dfs(Node root, int level){
        if(root == null)return;
        if(!map.containsKey(level)){
            map.put(level, root);
        }
        else{
            map.get(level).next = root;
            map.put(level, root);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}

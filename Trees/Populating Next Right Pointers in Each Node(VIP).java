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
    public Node connect(Node root) {
        return connectIterative(root);                

    }
    //O(1) space and O(N) time where N is the number of nodes
    public Node connectIterative(Node root){
        if(root == null)return null;
                
        Node curr = root;
        
        while(curr.left != null){
            
            Node parent = curr;
            Node child = curr.left;
            
            while(parent != null){
                child.next = parent.right;
                child = child.next;
                
                while(parent != null){
                    parent = parent.next;
                    if(parent == null)break;
                    
                    child.next = parent.left;
                    child = child.next;
                    
                    child.next = parent.right;
                    child = child.next;
                }
            }
            
            curr = curr.left;
        }
        return root;
    }
    //O(h) space and O(n) time, where h is the height of the tree
    public void connectDFS(Node root){
        if(root == null)return;
        Node curr = root;
        
        while(curr != null && curr.left != null){
            curr.left.next = curr.right; 
            if(curr.next != null)curr.right.next = curr.next.left;
            curr = curr.next;
        }
        connectDFS(root.left);
        connectDFS(root.right);
    }
}
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

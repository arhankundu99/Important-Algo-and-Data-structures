//https://www.lintcode.com/problem/convert-binary-search-tree-to-sorted-doubly-linked-list/description
public class Solution {
    TreeNode head = null, tail = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null)return null;
        inorder(root);
        
        tail.right = head;
        head.left = tail;
        
        return head;
    }
    public void inorder(TreeNode root){
        if(root == null)return;
        
        inorder(root.left);
        
        if(head == null){
            head = root;
            tail = head;
        }
        else{
            tail.right = root;
            root.left = tail;
            tail = tail.right;
        }
        inorder(root.right);
    }
}

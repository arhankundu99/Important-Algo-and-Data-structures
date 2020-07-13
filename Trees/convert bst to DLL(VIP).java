//https://www.lintcode.com/problem/convert-binary-search-tree-to-sorted-doubly-linked-list/description
public class Solution {
    /**
     * @param root: root of a tree
     * @return: head node of a doubly linked list
     */
    TreeNode head = null;
    TreeNode curr = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null)return head;
        helper(root);
        curr.right = head;
        head.left = curr;
        return head;
    }
    public TreeNode helper(TreeNode root) {
        if(root == null)return head;
        helper(root.left);
        if(head == null){
            head = root;
            curr = head;
        }
        else{
            curr.right = root;
            curr.right.left = curr;
            curr = curr.right;
        }
        helper(root.right);
        return head;
    }
}

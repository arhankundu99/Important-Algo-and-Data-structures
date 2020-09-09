// https://leetcode.com/problems/validate-binary-search-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// do this in interview
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long min, long max){
        if(root == null)return true;
        
        if(!(root.val >= min && root.val <= max))return false;
        
        long val = root.val;
        
        return isValidBST(root.left, min, val-1) && isValidBST(root.right, val+1, max);
    }
}


class Solution {
    ArrayList<Integer>list;
    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        return isSorted();
    }
    public void inorder(TreeNode root){
        if(root == null)return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public boolean isSorted(){
        if(list.size() == 0)return true;
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) >= list.get(i+1))return false;
        }
        return true;
    }
}

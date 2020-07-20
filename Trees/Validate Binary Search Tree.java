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

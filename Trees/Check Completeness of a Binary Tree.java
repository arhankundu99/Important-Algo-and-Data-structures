// https://leetcode.com/problems/check-completeness-of-a-binary-tree/
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
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        boolean flag = false;
        
        while(queue.size() != 0){
            TreeNode node = queue.poll();
            
            if(node.left != null){
                if(flag)return false;
                queue.add(node.left);
            }
            else flag = true; 
            
            if(node.right != null){
                if(flag)return false;
                
                queue.add(node.right);
            }
            else flag = true;
        }
        return true;
    }
}

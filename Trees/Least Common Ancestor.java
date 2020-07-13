//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
    
        helper(root, p, path1);
        helper(root, q, path2);
        
        for(int i = 0; i < path1.size(); i++){
            if(path1.get(i) == path2.get(i)){
                if(i+1 == path1.size() || i+1 == path2.size() || path1.get(i+1) != path2.get(i+1))return path1.get(i);
            }
        }
        return root;
    }
    public boolean helper(TreeNode root, TreeNode p, List<TreeNode> path){
        if(root == null)return false;
        if(root == p){
            path.add(root);
            return true;
        }
        path.add(root);
        if(helper(root.left, p, path))return true;
        if(helper(root.right, p, path))return true;
        
        path.remove(path.size()-1);
        return false;
    }
 
}

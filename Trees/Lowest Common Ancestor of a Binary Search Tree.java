// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3819/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        
        if(root.val < p.val && root.val < q.val)return lowestCommonAncestor(root.right, p, q);
        if(root.val > p.val && root.val > q.val)return lowestCommonAncestor(root.left, p, q);
        
        return root;
    }
}

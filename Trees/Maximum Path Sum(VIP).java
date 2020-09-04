// https://leetcode.com/problems/binary-tree-maximum-path-sum/
class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int temp = maxPathSumUtil(root);
        return ans;
    }
    public int maxPathSumUtil(TreeNode root) {
        if(root == null)return 0;
        
        int l = maxPathSumUtil(root.left);
        int r = maxPathSumUtil(root.right);
        
        int temp = Math.max(root.val+Math.max(l, r), root.val);
        
        ans = Math.max(ans, Math.max(temp, l+r+root.val));
        
        return temp;
    }
}

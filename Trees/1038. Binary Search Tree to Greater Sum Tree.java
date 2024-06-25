// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
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
    public TreeNode bstToGst(TreeNode root) {
        List<TreeNode> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);

        int sum = inorderList.get(inorderList.size() - 1).val;
        for (int i = inorderList.size() - 2; i >= 0; i--) {
            sum += inorderList.get(i).val;
            inorderList.get(i).val = sum;
        }
        return root;
    }

    private void inorderTraversal(TreeNode node, List<TreeNode> inorderList) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, inorderList);
        inorderList.add(node);
        inorderTraversal(node.right, inorderList);
    }
}
// https://leetcode.com/problems/balance-a-binary-search-tree/
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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);

        TreeNode newRoot = buildBST(inorderList, 0, inorderList.size() - 1);

        return newRoot;
    }

    private void inorderTraversal(TreeNode node, List<TreeNode> inorderList) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, inorderList);
        inorderList.add(node);
        inorderTraversal(node.right, inorderList);
    }

    private TreeNode buildBST(List<TreeNode> inorderList, int leftIdx, int rightIdx) {
        if (leftIdx > rightIdx) {
            return null;
        }
        int mid = (leftIdx + rightIdx) / 2;
        TreeNode newRoot = inorderList.get(mid);
        newRoot.left = buildBST(inorderList, leftIdx, mid - 1);
        newRoot.right = buildBST(inorderList, mid + 1, rightIdx);
        return newRoot;
    }
}
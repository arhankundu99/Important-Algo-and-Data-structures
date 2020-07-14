//https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)return null;
        
        TreeNode root = new TreeNode(preorder[idx++]);
        
        int inIdx = getIdx(inorder, 0, inorder.length-1, root.val);
        
        root.left = buildTree(preorder, inorder, 0, inIdx-1);
        root.right = buildTree(preorder, inorder, inIdx+1, inorder.length-1);
        
        return root;
    }
    public int getIdx(int[] inorder, int startIdx, int endIdx, int val){
        for(int i = startIdx; i <= endIdx; i++){
            if(inorder[i] == val)return i;
        }
        return -1;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int startIdx, int endIdx) {
        if(startIdx > endIdx)return null;
        
        TreeNode root = new TreeNode(preorder[idx++]);
        
        if(startIdx == endIdx)return root;
        
        int inIdx = getIdx(inorder, startIdx, endIdx, root.val);
        
        root.left = buildTree(preorder, inorder, startIdx, inIdx-1);
        root.right = buildTree(preorder, inorder, inIdx+1, endIdx);
        
        return root;
    }
}

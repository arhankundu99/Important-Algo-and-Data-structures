// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    int idx;
    Map<Integer, Integer>map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)return null;
        idx = inorder.length - 1;
        
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)map.put(inorder[i], i);
        
        TreeNode root = new TreeNode(postorder[idx--]);
        
        int inIdx = getIdx(inorder, 0, inorder.length-1, root.val);
        
        // !!! Notice this order
        root.right = buildTree(inorder, postorder, inIdx+1, inorder.length-1);
        root.left = buildTree(inorder, postorder, 0, inIdx-1);
        
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder, int startIdx, int endIdx) {
        if(startIdx > endIdx)return null;
        
        TreeNode root = new TreeNode(postorder[idx--]);
        
        if(startIdx == endIdx)return root;
        
        int inIdx = getIdx(inorder, startIdx, endIdx, root.val);

        root.right = buildTree(inorder, postorder, inIdx+1, endIdx);
        root.left = buildTree(inorder, postorder, startIdx, inIdx-1);

        
        return root;
    }
    public int getIdx(int[] inorder, int startIdx, int endIdx, int val){
        return map.get(val);
    }
}

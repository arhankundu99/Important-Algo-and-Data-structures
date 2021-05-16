// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3745/
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
    int count = 0;
    public int minCameraCover(TreeNode root) {
        if(dfs(root) == -1)count++;
        return count;
    }
    //return -1 if root needs a camera coverage
    //return 0 if root does not need a camera
    //return 1 if root has a camera
    public int dfs(TreeNode root){
        if(root == null)return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        if(left == 0 && right == 0){
            //this means both root.left and root.right are covered. therefore root needs camera camera coverage
            return -1;
        }
        if(left == -1 || right == -1){
            // this means both root.left and root.right need camera coverage. So a camera should be placed at root.
            count++;
            return 1;
        }
        //root.left or root.right has a camera. so root does not need camera coverage
        return 0;
        
    }
}

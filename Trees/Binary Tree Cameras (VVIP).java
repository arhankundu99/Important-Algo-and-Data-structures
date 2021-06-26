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
    //return -1 if root has a camera coverage
    //return 0 if root does not have a camera coverage
    //return 1 if root has a camera
    public int dfs(TreeNode root){
        if(root == null)return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        if(left == 0 && right == 0){
            //this means both root.left and root.right are covered. therefore root needs camera coverage
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

class Solution {
    public int minCameraCover(TreeNode root) {
        int[] arr = dfs(root);
        return Math.min(arr[1], arr[2]);
    }
    //three states
    //state1: All nodes below root are covered, except this one
    //state2: All nodes below root and including root are covered and no camera in root
    //state3: All nodes below root and including root are covered and there is camera in the root
    
    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0, 0, 99999};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        int s1 = left[1] + right[1];
        int s2 = Math.min(left[2] + Math.min(right[1], right[2]), right[2] + Math.min(left[1], left[2]));
        int s3 = 1 + Math.min(left[0], Math.min(left[1], left[2])) + Math.min(right[0], Math.min(right[1], right[2]));
                      
        return new int[]{s1, s2, s3};             
    }
}

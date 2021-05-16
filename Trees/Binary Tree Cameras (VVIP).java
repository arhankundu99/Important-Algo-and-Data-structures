// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3745/
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
            count++;
            return 1;
        }
        return 0;
        
    }
}

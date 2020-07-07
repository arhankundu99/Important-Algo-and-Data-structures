class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        dfs(root);
        return ans-1;
    }
    public int dfs(TreeNode node){
        if(node == null)return 0;
        int leftH = dfs(node.left);
        int rightH = dfs(node.right);
        
        ans = Math.max(ans, leftH+rightH+1);
        return 1+Math.max(leftH, rightH);
    }
}

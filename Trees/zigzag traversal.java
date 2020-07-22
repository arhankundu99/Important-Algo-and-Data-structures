// https://leetcode.com/explore/featured/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3398/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>();
        dfs(root, ans, 0);
        return ans;
    }
    public void dfs(TreeNode root, List<List<Integer>>ans, int level){
        if(root == null)return;
        
        if(level == ans.size())ans.add(new ArrayList<>());
        
        if(level % 2 == 0)ans.get(level).add(root.val);
        else ans.get(level).add(0, root.val);
        
        dfs(root.left, ans, level+1);
        dfs(root.right, ans, level+1);
    }
}

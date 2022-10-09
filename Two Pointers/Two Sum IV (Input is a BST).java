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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        int low = 0, high = inorderList.size() - 1;

        while(low <= high){
            int sum = inorderList.get(low) + inorderList.get(high);
            if(sum == k)
                return true;
            
            else if(sum > k){
                high--;
            }
            else low++;
        }

        return false;
    }

    public void inorder(TreeNode root, List<Integer> inorderList){
        if(root == null)
            return;

        inorder(root.left, inorderList);
        inorderList.add(root.val);
        inorder(root.right, inorderList);
    }
}

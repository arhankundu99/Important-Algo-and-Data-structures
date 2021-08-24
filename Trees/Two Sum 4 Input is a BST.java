//https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3908/
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
        
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        
        addNode(leftStack, root, true);
        addNode(rightStack, root, false);
        
        while(leftStack.peek().val != rightStack.peek().val){
            //System.out.println(leftStack.peek().val + " " + rightStack.peek().val);
            int sum = leftStack.peek().val + rightStack.peek().val;
            
            if(sum == k)return true;
            else if(sum > k){
                TreeNode node = rightStack.pop();
                addNode(rightStack, node.left, false);
            }
            else{
                TreeNode node = leftStack.pop();
                addNode(leftStack, node.right, true);
            }
        }
        
        return false;
    }
    public void addNode(Stack<TreeNode> stack, TreeNode root, boolean isLeft){
        while(root != null){
            stack.push(root);
            //System.out.println(root.val);
            root = isLeft? root.left: root.right;
        }
    }

}

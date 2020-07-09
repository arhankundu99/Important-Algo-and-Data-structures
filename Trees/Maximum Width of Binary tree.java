//Deque is used
//https://leetcode.com/problems/maximum-width-of-binary-tree/
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)return 0;

        Deque<pair>queue = new LinkedList<>();
        queue.add(new pair(root, 0, 0, 0));
        int ans = 1;
        
        while(queue.size() != 0){
            pair pair = queue.poll();
            TreeNode node = pair.node;
            int pos = pair.pos;
            int level = pair.level;
            
            if(node.left != null)
            {
                TreeNode currNode = node.left;
                int currPos = 2*pos+1;
                int currLeftMost = 2*pos+1;
                int currLevel = level+1;
                if(queue.size() != 0 && queue.peekLast().level == currLevel){
                    currLeftMost = queue.peekLast().leftMost;
                }
                ans = Math.max(ans, currPos - currLeftMost + 1);
                queue.add(new pair(currNode, currPos, currLeftMost, currLevel));
                
            }
            
            if(node.right != null){
                TreeNode currNode = node.right;
                int currPos = 2*pos+2;
                int currLeftMost = 2*pos+2;
                int currLevel = level+1;

                if(queue.size() != 0 && queue.peekLast().level == currLevel){
                    currLeftMost = queue.peekLast().leftMost;
                }
                ans = Math.max(ans, currPos - currLeftMost + 1);
                queue.add(new pair(currNode, currPos, currLeftMost, currLevel));
                
            }
        }
        return ans;
    }
}
class pair{
    TreeNode node;
    int pos;
    int leftMost;
    int level;
    pair(TreeNode node, int pos, int leftMost, int level){
        this.node = node;
        this.pos = pos;
        this.leftMost = leftMost;
        this.level = level;
    }
}

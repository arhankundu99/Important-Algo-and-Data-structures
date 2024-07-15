// https://www.lintcode.com/problem/650/?fromId=213&_from=collection
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
import java.util.*;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Solution {
    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */ 
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        findLeaves(root, result);
        return result;
    }

    private int findLeaves(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return 0;
        }
        int height = 1 + Math.max(findLeaves(root.left, result), findLeaves(root.right, result));

        if (result.size() < height) {
            result.add(new ArrayList<>());
        }
        result.get(height - 1).add(root.val);
        return height;
    }
}

public class FindLeavesOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println((new Solution()).findLeaves(root));
    }
}

// https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1
class GfG
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    int idx;
    Node binaryTreeToBST(Node root)
    {
        int n = countNodes(root);
       
        // it will store the node values in the tree;
        int[] arr = new int[n];
        
        idx = 0;
        dfs(arr, root);
       
        Arrays.sort(arr);
        
        idx = 0;   
        inorder(root, arr);
        
        return root;
    }
    void dfs(int[] arr, Node root){
        if(root == null)return;
        
        arr[idx++] = root.data;
        dfs(arr, root.left);
        dfs(arr, root.right);
    }
    void inorder(Node root, int[] arr){
        if(root == null)return;
        
        inorder(root.left, arr);
        root.data = arr[idx++];
        inorder(root.right, arr);
    }
    int countNodes(Node root){
        if(root == null)return 0;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

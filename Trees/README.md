##### DO NOT FORGET THE CORNER CASES WHILE SOLVING A TREE PROBLEM like if node is null or node is a leaf node

## BST

A binary search tree is a tree with a property that the values of the left subtree is less than than the root's value and values of the right subtree is more than the root's value and same property follows for all the nodes

#### Insertion of a node

```java
Node insert(Node root, int key)
    {
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(root.data < key){   
            if(root.right == null){
                root.right = new Node(key);
                return root;
            }
            insert(root.right, key);
        }
        else if(root.data > key){
            if(root.left == null){
                root.left = new Node(key);
                return root;
            }
            insert(root.left, key);
        }
        return root;
    }
````
Takes O(h) time where h is the height of the tree (Worst case: O(n) time)

#### Searching also takes O(h) time (Worst case: O(n) time)

#### Deletion of a node

```java
	public static Node deleteNode(Node root, int X)
	{
		if(root == null)return null;
	
		if(root.data < X)root.right = deleteNode(root.right, X);
		else if(root.data > X) root.left = deleteNode(root.left, X);
		else{
		    //for nodes which have 1 child or no child
		    if(root.left == null)return root.right;
		    if(root.right == null)return root.left;
		
		    Node successor = findSuccessor(root);
		
		    root.data = successor.data;
		
		    root.right = deleteNode(root.right, successor.data);
		}
		return root;
	}
	public static Node findSuccessor(Node root){
	    Node curr = root.right;
	    while(curr.left != null)curr = curr.left;
	    return curr;
	}
  ```

### Comparisons b/w tree, bst and AVL (Height balanced BSTs)

#### insertion, Searching and deletion:
1) Tree takes O(n) time (worst case)
2) Bst takes O(h) time (worst case O(n) time in case of a skewed tree)
3) AVL takes O(logn) time (As they are height balanced trees)


# Tree traversals
```java

//inorder
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        
        Stack<TreeNode>stack = new Stack<>();
        
        TreeNode curr = root;
        
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            
            curr = curr.right;
        }
        return list;
    }
}

// preorder
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        while(curr != null || stack.size() != 0){
            while(curr != null){
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return list;
    }
}

//postorder
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode>stack = new Stack<>();
        
        TreeNode curr = root;
        
        while(curr != null || stack.size() != 0){
            while(curr != null){
                stack.push(curr);
                list.add(curr.val);
                curr = curr.right;
            }
            curr = stack.pop();
            curr = curr.left;
        }
        Collections.reverse(list);
        return list;
    }
}
note that postorder is obtained by making slight modications in preorder code
instead of DLR we are doing DRL and reversing the list
```

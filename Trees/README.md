Height Balanced Trees: [AVL Trees](https://www.geeksforgeeks.org/avl-tree-set-1-insertion/) <br/>
[Practice Link](https://practice.geeksforgeeks.org/problems/avl-tree-insertion/1)
```java
class Sol
{
    public  Node insertToAVL(Node node,int data)
    {
        if(node == null)return new Node(data);
        
        if(node.data < data)node.right = insertToAVL(node.right, data);
        else if(node.data > data)node.left = insertToAVL(node.left, data);
        else return node;
        
        int balance = getBalance(node);
        
        //LL case
        if(balance > 1 && data < node.left.data){
            return rightRotate(node);
        }
        
        //RR case
        if(balance < -1 && data > node.right.data){
            return leftRotate(node);
        }
        
        //LR case
        if(balance > 1 && data > node.left.data){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        //RL case
        if(balance < -1 && data < node.right.data){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    public Node leftRotate(Node x){
        Node y = x.right;
        Node z = y.left;
        
        y.left = x;
        x.right = z;
        
        return y;
    }
    public Node rightRotate(Node x){
        Node y = x.left;
        Node z = y.right;
        
        y.right = x;
        x.left = z;
        
        return y;
    }
    public int height(Node node){
        if(node == null)return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public int getBalance(Node node){
        return height(node.left) - height(node.right);
    }
}    
```
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

# Advantages of BST over Hash Table

Hash Table supports following operations in Θ(1) time.
1) Search
2) Insert
3) Delete

The time complexity of above operations in a self-balancing Binary Search Tree (BST) (like Red-Black Tree, AVL Tree, Splay Tree, etc) is O(Logn).
So Hash Table seems to beating BST in all common operations. When should we prefer BST over Hash Tables, what are advantages. Following are some important points in favor of BSTs.

We can get all keys in sorted order by just doing Inorder Traversal of BST. This is not a natural operation in Hash Tables and requires extra efforts.
Doing order statistics, finding closest lower and greater elements, doing range queries are easy to do with BSTs. Like sorting, these operations are not a natural operation with Hash Tables.
BSTs are easy to implement compared to hashing, we can easily implement our own customized BST. To implement Hashing, we generally rely on libraries provided by programming languages.
With Self-Balancing BSTs, all operations are guaranteed to work in O(Logn) time. But with Hashing, Θ(1) is average time and some particular operations may be costly, especially when table resizing happens.

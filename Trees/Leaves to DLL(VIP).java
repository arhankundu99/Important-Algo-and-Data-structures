//https://practice.geeksforgeeks.org/problems/leaves-to-dll/1
//Important ques: Notice the order
/*
Node is as follows:
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Tree{
    Node head = null;
    Node curr = null;
    // return the head of the DLL and remove those node from the tree as well.
    public Node convertToDLL(Node root)
    {
        if(root == null)return head;
        if(isLeafNode(root.left)){
            if(head == null){
                head = root.left;
                curr = head;
            }
            else{
                curr.right = root.left;
                curr.right.left = curr;
                curr = curr.right;
            }
            root.left = null;
        }
        convertToDLL(root.left);
        
        if(isLeafNode(root.right)){
            if(head == null){
                head = root.right;
                curr = head;
            }
            else{
                curr.right = root.right;
                curr.right.left = curr;
                curr = curr.right;
            }
            root.right = null;
        }
        convertToDLL(root.right);
        return head;
    }
    public boolean isLeafNode(Node node){
        if(node == null)return false;
        if(node.left == null && node.right == null)return true;
        return false;
    }
}

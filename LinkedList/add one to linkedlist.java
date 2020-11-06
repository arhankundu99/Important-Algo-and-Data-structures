// https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
class Sol
{
    public static Node addOne(Node head) 
    {
        int carry = getCarry(head);
        if(carry == 0)return head;
        Node node = new Node(carry);
        node.next = head;
        return node;
    }
    public static int getCarry(Node head){
        if(head == null)return 1;
        int carry = getCarry(head.next);
        int sum = head.data + carry;
        if(sum == 10){
            head.data = 0;
            return 1;
        }
        head.data = sum;
        return 0;
    }
}

// https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3522/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = getSize(l1);
        int size2 = getSize(l2);
        
        if(size2 > size1){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        
        ListNode curr = l1.next;
        while(curr != null){
            tail.next = new ListNode();
            tail = tail.next;
            curr = curr.next;
        }
        int diff = Math.abs(size1 - size2);
        
        int carry = getCarry(l1, l2, head, diff);
        
        if(carry != 0){
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        return head;
    }
    public int getCarry(ListNode l1, ListNode l2, ListNode node, int diff){
        if(l1 == null)return 0;
        
        int sum = 0, carry = 0;
        
        if(diff != 0){
            carry = getCarry(l1.next, l2, node.next, diff - 1);
            sum = l1.val + carry;
        }
        else{
            carry = getCarry(l1.next, l2.next, node.next, diff);
            sum = l1.val + l2.val + carry;
        }
        node.val = sum % 10;
        return sum / 10;
    }
    public int getSize(ListNode l1){
        ListNode curr = l1;
        int size = 0;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        return size;
    }
}

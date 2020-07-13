//https://leetcode.com/problems/reverse-nodes-in-k-group/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)return null;
        
        int length = getLength(head);
        if(length < k)return head;
        
        ListNode prev = null, curr = head, next = null;
        
        int count = 1;
        while(count <= k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        ListNode tail = head;
        head = prev;
        
        for(int i = 1; i <= (length/k) -1; i++){
            next = null;
            prev = null;
            count = 1;
            
            ListNode dummyTail = curr;
            
            while(count <= k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            
            tail.next = prev;
            tail = dummyTail;
        }
        tail.next = curr;
        return head;
    }
    public int getLength(ListNode node){
        int length = 0;
        while(node != null){
            length++;
            node = node.next;
        }
        return length;
    }
}

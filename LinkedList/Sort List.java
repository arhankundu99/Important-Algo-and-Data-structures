/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;
        
        int length = getLength(head);
        
        ListNode tail = getMiddle(head, length);
        
        ListNode head2 = tail.next;
        
        tail.next = null;
        
        head = sortList(head);
        head2 = sortList(head2);
        
        return merge(head, head2);
    }
    public int getLength(ListNode node){
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        return count;
    }
    public ListNode getMiddle(ListNode node, int length){
        int count = 0;
        while(count < length/2){
            node = node.next;
            count++;
        }
        return node;
    }
    public ListNode merge(ListNode node1, ListNode node2){
        if(node1 == null)return node2;
        if(node2 == null)return node1;
        
        ListNode head = null;
        
        if(node1.val < node2.val){
            head = node1;
            node1 = node1.next;
        }
        else{
            head = node2;
            node2 = node2.next;
        }
        
        ListNode tail = head;
        
        while(node1 != null && node2 != null){
            if(node1.val < node2.val){
                tail.next = node1;
                node1 = node1.next;
                tail = tail.next;
            }
            else{
                tail.next = node2;
                node2 = node2.next;
                tail = tail.next;
            }
        }
        if(node1 == null)tail.next = node2;
        else tail.next = node1;
        
        return head;
    }
}

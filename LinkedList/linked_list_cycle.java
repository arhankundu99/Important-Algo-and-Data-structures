// Prob no 141
//Given a linked list, determine if it has a cycle in it.
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)return false;
        
        ListNode hare = head;
        ListNode tortoise = head;
        while(hare!=null && hare.next!=null)
        {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(tortoise == hare)return true;
        }
        return false;
    }
}

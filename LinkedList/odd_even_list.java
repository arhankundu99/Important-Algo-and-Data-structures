// leetcode prob no 328
//Given a singly linked list, group all odd nodes together followed by the even nodes

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null)return head;
        
        ListNode odd = head;
        ListNode join = head.next;
        ListNode even = head.next;
        
        while(even!=null&&odd!=null)
        {
            
            odd.next = even.next;
            if(odd.next==null)break;
            even.next = odd.next.next;
            
            odd = odd.next;
            even = even.next;
        }
        odd.next = join;
        return head;
    }
}

// leetcode prob 21
//Merge two sorted linked lists and return it as a new list. 
//The new list should be made by splicing together the nodes of the first two lists.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1==null)return l2;
        if(l2==null)return l1;
        
        ListNode head;
        if(l1.val<l2.val)
        {
            head = l1;
            l1 = l1.next;
        }
        else
        {
            head = l2;
            l2 = l2.next;
        }
        ListNode tail = head;
        while(l1!=null&&l2!=null)
        {
            if(l1.val<l2.val)
            {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }
            else
            {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next; 
            }
        }
        if(l1 == null)tail.next = l2;
        else tail.next = l1;
        
        return head;
    }
}

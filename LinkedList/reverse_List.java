// leetcode prob no 206
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Iterative Solution
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null,next = null,curr = head;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
//Recursive Solution
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)return null;
        return reverse(null, head);
    }
    public ListNode reverse(ListNode prev, ListNode curr)
    {
        if(curr.next == null)
        {
            curr.next = prev;
            return curr;
        }
        ListNode next = curr.next;
        curr.next = prev;
        return reverse(curr, next);
    }
}

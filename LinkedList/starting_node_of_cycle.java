//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                slow=head;
                while(slow!=fast)
                {
                    slow=slow.next;
                    fast=fast.next;
                    if(slow==fast)return slow;
                }
                return slow;
            }
        }
        return null;
    }
}
// Why this works: Visit: https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/ for explanation

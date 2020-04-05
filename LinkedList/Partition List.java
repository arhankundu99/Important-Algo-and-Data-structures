/**
 * Definition for singly-linked list.
 //Given a linked list and a value B, partition it such that all nodes less than x come before nodes greater than or equal to B.
 /* class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode A, int B) {
        ListNode prev=A;
        ListNode curr=A;
        while(curr!=null)
        {
            if(curr.val<B)
            {
                swap(prev,curr);
                prev=prev.next;
            }
            curr=curr.next;
        }
        return A;
    }
    public void swap(ListNode prev,ListNode curr)
    {
        int temp=prev.val;
        prev.val=curr.val;
        curr.val=temp;
    }
}

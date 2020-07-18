// leetcode Prob no 141
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
// This above algorithm is known as floyd algorithm.
// Why this works? If there is a cycle the hare and tortoise are bound to meet because the relative 
// speed of hare wrt tortoise is 1 unit. Once the hare and tortoise are inside the cycle, you can imagine
// that tortoise is stationary and hare moves by 1 unit forward since the relative speed is 1 unit.
// So they are bound to meet if a cycle exists

// What will happen if the hare moves n times faster where n > 2?



// Another method
// Use hashing
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode>set = new HashSet<>();
        ListNode node = head;
        while(node!=null)
        {
            if(set.contains(node))return true;
            set.add(node);
            node = node.next;
        }
        return false;
    }
}

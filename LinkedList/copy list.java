//leetcode 138
//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//Return a deep copy of the list.

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        Map<Node, Node>map = new HashMap<>();
        Node copy = new Node(head.val), curr1 = head, curr2 = copy;
        while(curr1.next != null)
        {
            map.put(curr1, curr2);
            curr2.next = new Node(curr1.next.val);
            curr2 = curr2.next;
            curr1 = curr1.next;
        }
        map.put(curr1, curr2);
        for(Node x: map.keySet())map.get(x).random = map.get(x.random);
        return copy;
    }
}
// for O(1) space look https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)

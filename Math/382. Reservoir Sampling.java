// https://leetcode.com/problems/linked-list-random-node/description/
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

 // Algorithm 
 // Use reservoir sampling to get random values

 // function reservoirSampling(A, K) {
    // Initialise a random array of size K
    // for i from 0 to K:
    //     random[i] = A[i]
    // for i from K to A.length:
    //     randomIdx = random(0, i) inclusive
    //     if randomIdx < K
    //         random[randomIdx] = A[i]


    // Now the probability that ith element gets selected during the current iteration is k / i
    // Now the probability that jth element replaces the ith element is (probability of jth element gets chosen) * (probability of jth element replaces ith element)
    // = (k / j) * (1 / k) = (1 / j)
    // Probability that jth element does not replace ith element = 1 - (1 / j) = (j - 1) / j
    // Probability that ith element remains till end = (k / i) * (i / i + 1) * (i + 1 / i + 2) ..... (N - 1 / N) = (k / N)
}
class Solution {
    private ListNode head;
    int K = 1;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int[] random = new int[K];
        ListNode curr = head;
        for (int i = 0; i < K; i++) {
            random[i] = curr.val;
            curr = curr.next;
        }

        int currIdx = K;
        while (curr != null) {
            int val = curr.val;
            int randomIdx = (int)(Math.random() * (currIdx + 1));

            if (randomIdx < K) {
                random[randomIdx] = curr.val;
            }
            curr = curr.next;
            currIdx++;
        }
        return random[0];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
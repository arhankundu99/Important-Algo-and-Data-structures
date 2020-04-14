// Leetcode prob no 215
//Find the kth largest element in an unsorted array. 
//Note that it is the kth largest element in the sorted order, not the kth distinct element.


//Time complexity - O(NlogK)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>(k+1);
        for(int x: nums)
        {
            if(pq.size()<k)pq.add(x);
            else
            {
                pq.add(x);
                pq.poll();
            }
        }
        return pq.poll();
    }
}

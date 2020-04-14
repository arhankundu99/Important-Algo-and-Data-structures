//Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
//You can only see the k numbers in the window. 
//Each time the sliding window moves right by one position. Return the max sliding window.
// Very Important Problem

// Using Priority Queue O(NlogK) time
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer>priorityQueue = new PriorityQueue<>(nums.length-k+1,new Comparator<Integer>(){
           public int compare(Integer a, Integer b)
           {
               return b-a;
           }
        });
        int[]ret = new int[nums.length-k+1];
        for(int i=0;i<k;i++)priorityQueue.add(nums[i]);
        ret[0] = priorityQueue.peek();
        int idx=1;
        for(int i=k;i<nums.length;i++)
        {
            priorityQueue.remove(nums[i-k]);
            priorityQueue.add(nums[i]);
            ret[idx++] = priorityQueue.peek();
        }
        return ret;
    }
}
// Using monoqueue O(n) time
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        monoQueue mq = new monoQueue();
        int[]ret = new int[nums.length-k+1];
        int idx = 0;
        for(int i=0;i<k-1;i++)mq.push(nums[i]);
        for(int i=k-1;i<nums.length;i++)
        {
            mq.push(nums[i]);
            ret[idx++] = mq.max();
            mq.remove(nums[i-k+1]);
        }
        return ret;
    }
}
class monoQueue
{
    Deque<Integer>deque;
    public monoQueue()
    {
        deque = new LinkedList<>();
    }
    void push(int x)
    {
        while(!deque.isEmpty() && deque.peekLast() < x)deque.pollLast();
        deque.addLast(x);
    }
    int max()
    {
        return deque.peekFirst();
    }
    void remove(int x)
    {
        if(x == deque.peekFirst())deque.pollFirst();
    }
}

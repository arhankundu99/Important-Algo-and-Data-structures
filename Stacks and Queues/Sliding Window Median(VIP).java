// leetcode 490 (HARD)
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position. 
Your job is to output the median array for each window in the original array.

//See this : https://leetcode.com/problems/sliding-window-median/discuss/96352/Never-create-max-heap-in-java-like-this...

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){return b.compareTo(a);}
        });
        PriorityQueue<Integer>minHeap = new PriorityQueue<>();
        
        double[] ans = new double[nums.length-k+1];
        
        for(int i=0;i<k;i++)
        {
            minHeap.add(nums[i]);
            maxHeap.add(minHeap.poll());
            
            if(minHeap.size() < maxHeap.size())
                minHeap.add(maxHeap.poll());
        }
        if(minHeap.size() == maxHeap.size())ans[0] = ((double)minHeap.peek()+(double)maxHeap.peek())/2.0;
        else ans[0] = (double)minHeap.peek();
        
        int idx = 1;
        
        for(int i=k;i<nums.length;i++)
        {
            minHeap.add(nums[i]);
            maxHeap.add(minHeap.poll());
            
            if(minHeap.size() < maxHeap.size())
                minHeap.add(maxHeap.poll());
            
            if(minHeap.peek() <= nums[i-k])minHeap.remove(nums[i-k]);
            else maxHeap.remove(nums[i-k]);
            
            if(minHeap.size() - maxHeap.size() > 1)maxHeap.add(minHeap.poll());
            else if(maxHeap.size() > minHeap.size())minHeap.add(maxHeap.poll());
            
            if(maxHeap.size() == minHeap.size())ans[idx] = ((double)minHeap.peek()+(double)maxHeap.peek())/2.0;
            else ans[idx] = (double)minHeap.peek();
            
            idx++;
        }
        return ans;
    }
}

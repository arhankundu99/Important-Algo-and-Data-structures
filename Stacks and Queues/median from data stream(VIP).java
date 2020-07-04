// leetcode 295 (HARD)
void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.

class MedianFinder {

    PriorityQueue<Integer>minHeap, maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){return b-a;}
        });
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        
        if(minHeap.size() < maxHeap.size())
            minHeap.add(maxHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
            return (minHeap.peek()+maxHeap.peek())/2.0;
        return minHeap.peek();
    }
}
// Please look into the below picture for pictorial Explanation.
//https://www.programcreek.com/wp-content/uploads/2015/01/Find-Median-from-Data-Stream-730x408.png
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

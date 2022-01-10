class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    boolean even;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        even = true;
    }
    
    public void addNum(int num) {
        if(even){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll()); 
        } else{
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even) return ((double)maxHeap.peek()+(double)minHeap.peek())/2;
        else return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
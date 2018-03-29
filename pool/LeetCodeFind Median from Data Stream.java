public class MedianFinder {
    private Queue<Integer> maxHeap;
    private Queue<Integer> minHeap;// values in minHeap >= values in maxHeap
    /** initialize your data structure here. */
    public MedianFinder() {
      maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
        @Override
        public int compare(Integer i1, Integer i2){
          return i2 - i1;
        }
      });
      minHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
      if(minHeap.isEmpty() || num >= minHeap.peek()) minHeap.add(num);
      else maxHeap.add(num);

      while(minHeap.size() < maxHeap.size() - 1)
        minHeap.add(maxHeap.poll());

      while(maxHeap.size() < minHeap.size() - 1)
        maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
      if(maxHeap.size() == minHeap.size() + 1) return maxHeap.peek();
      else if( maxHeap.size() == minHeap.size() - 1) return minHeap.peek();
      else return ( (double)maxHeap.peek() + (double)minHeap.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

class MedianFinder {
    private PriorityQueue<Integer> smallheap;
    private PriorityQueue<Integer> largeheap;
    public MedianFinder() {
        smallheap = new PriorityQueue<>((a, b) -> b - a);
        largeheap = new PriorityQueue<>();

    }
    
    public void addNum(int num) {
        smallheap.offer(num);

        if(smallheap.size() - largeheap.size() > 1 || (!largeheap.isEmpty() && largeheap.peek() < smallheap.peek())){
            largeheap.offer(smallheap.poll());
        }

        if(largeheap.size() - smallheap.size() > 1){
            smallheap.offer(largeheap.poll());
        }
    }
    
    public double findMedian() {
        if (largeheap.size() > smallheap.size()){
            return largeheap.peek();
        }else if(smallheap.size() > largeheap.size()){
            return smallheap.peek();
        }else{
            return (double) (largeheap.peek() + smallheap.peek()) / 2;
        }
    }
}

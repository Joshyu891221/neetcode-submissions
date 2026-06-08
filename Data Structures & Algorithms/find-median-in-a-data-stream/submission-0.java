class MedianFinder {
    private Queue<Integer> smallheap;
    private Queue<Integer> largeheap;

    public MedianFinder() {
        smallheap = new PriorityQueue<>((a, b) -> b - a);
        largeheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallheap.offer(num);

        if(
            smallheap.size() - largeheap.size() > 1 ||
            (!largeheap.isEmpty() && 
            largeheap.peek() < smallheap.peek())
        ){
            largeheap.offer(smallheap.poll());
        }
        if(largeheap.size() - smallheap.size() > 1){
            smallheap.offer(largeheap.poll());
        }
    }
    
    public double findMedian() {
        if(smallheap.size() == largeheap.size()){
            return (double) (smallheap.peek() + largeheap.peek()) / 2;
        }else if (smallheap.size() > largeheap.size()){
            return (double)smallheap.peek();
        }else{
            return (double)largeheap.peek();
        }
    }
}

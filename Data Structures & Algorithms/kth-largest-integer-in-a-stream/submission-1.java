class KthLargest {
    private PriorityQueue<Integer> minheap;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        this.minheap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums){
            minheap.offer(num);
        }
    }
    
    public int add(int val) {

        minheap.offer(val);
        while (minheap.size() > k){
            minheap.poll();
        }
        
        return minheap.peek();
    }
}

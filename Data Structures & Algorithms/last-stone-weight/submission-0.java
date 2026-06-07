class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone:stones){
            minheap.offer(stone);
        }

        while (minheap.size() > 1){
            int stone1 = minheap.poll();
            int stone2 = minheap.poll();
            if(stone1 > stone2) { minheap.offer(stone1 - stone2);}
            else if (stone1 < stone2) {minheap.offer(stone2 - stone1);}
            
        }
        return minheap.isEmpty()? 0 : minheap.peek();
    }
}

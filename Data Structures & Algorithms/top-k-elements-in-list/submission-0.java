class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums){ countMap.put(num, countMap.getOrDefault(num, 0) + 1);}

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> countMap.get(a) - countMap.get(b));

        for (int num : countMap.keySet()){
            heap.add(num);
            if(heap.size() > k){heap.poll();}
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i ++){
            res[i] = heap.poll();
        }
        System.out.print(heap);
        return res;
    }
}

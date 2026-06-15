class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++){
            queue.offer(new int[]{i, nums[i]});
        }
        res[0] = queue.peek()[1];
        for(int i = k; i < nums.length; i++){
            queue.offer(new int[]{i, nums[i]});
            
            while(i - k + 1 > queue.peek()[0]){
                queue.poll();
            }
            res[i - k + 1] = queue.peek()[1];
        }
        return res;
    }
}

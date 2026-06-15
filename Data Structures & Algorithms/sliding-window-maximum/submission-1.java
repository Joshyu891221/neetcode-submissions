class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];

        int l = 0, r = 0;

        while(r < n){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[r]){
                queue.pollLast();
            }

            queue.offerLast(r);

            if(l > queue.peekFirst()){
                queue.pollFirst();
            }

            if((r + 1) >= k){
                res[l] = nums[queue.peekFirst()];
                l++;
            }
            r++;
        }
        return res;


    }
}

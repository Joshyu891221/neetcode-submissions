class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
        for (int[] point:points){
            maxheap.offer(point);

            if (maxheap.size() > k) {
                maxheap.poll();
            }
        }

        int[][] res = new int[k][2]; 
        int index = 0;
        while (!maxheap.isEmpty()){
            int[] ans = maxheap.poll();
            res[index] = ans;
            index ++;
        }
        return res; 
    }
}

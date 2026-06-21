class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if(n == 1) return 0;

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minheap.offer(new int[]{0,0});

        int res = 0;
        int countNode = 0;

        while(!minheap.isEmpty()){
            int[] node = minheap.poll();
            int v = node[0];
            int dist = node[1];
            if(visited[v]) continue;

            res += dist;
            visited[v] = true;
            countNode ++;

            if (countNode == n) break;

            for(int nv = 0; nv < n; nv++){
                if(visited[nv]) continue;
                
                int nextDist = Math.abs(points[v][0] - points[nv][0]) + Math.abs(points[v][1] - points[nv][1]);
                minheap.offer(new int[]{nv, nextDist});
            }
            
        }
        return res;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj =  new HashMap<>();

        for(int[] f : flights){
            adj.computeIfAbsent(f[0], key -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int[] stopLeft = new int[n];
        Arrays.fill(stopLeft, -1);

        int[] mincosts = new int[n];
        Arrays.fill(mincosts, Integer.MAX_VALUE);

        pq.offer(new int[]{src, 0, k + 1});
        stopLeft[src] = k + 1;
        mincosts[src] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int airport = curr[0];
            int mincost = curr[1];
            int remainStops = curr[2];

            if(airport == dst) return mincost;

            if(remainStops == 0 || !adj.containsKey(airport)) continue;

            for(int[] neighbor : adj.get(airport)){
                int nextAP = neighbor[0];
                int nextSpend = neighbor[1];

                if(remainStops - 1 > stopLeft[nextAP] || nextSpend + mincost < mincosts[nextAP]){
                    if(remainStops - 1 > stopLeft[nextAP]) stopLeft[nextAP] = remainStops - 1;
                    if(nextSpend + mincost < mincosts[nextAP]) mincosts[nextAP] = nextSpend + mincost;
                    pq.offer(new int[]{nextAP, nextSpend + mincost, remainStops - 1});
                }
            }

            

        }

        return -1;
        
    }
}

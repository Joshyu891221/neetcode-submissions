class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] f : flights){
            adj.computeIfAbsent(f[0], key -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int[] stops = new int[n];
        Arrays.fill(stops, -1);

        int[] minCosts = new int[n];
        Arrays.fill(minCosts, Integer.MAX_VALUE);

        pq.offer(new int[]{src, 0, k + 1});
        stops[src] = k + 1;
        minCosts[src] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int airport = curr[0];
            int mincost = curr[1];
            int remainStops = curr[2];

            if(airport == dst) return mincost;

            if(remainStops == 0) continue;
            
            if(!adj.containsKey(airport)) continue;
            
            for(int[] neighbor : adj.get(airport)){
                int nextAP = neighbor[0];
                int nextCost = neighbor[1];
                int nextMincost = mincost + nextCost;

                if (remainStops - 1 > stops[nextAP] || nextMincost < minCosts[nextAP]) {

                    if (remainStops - 1 > stops[nextAP]) {
                        stops[nextAP] = remainStops - 1;
                    }
                    if (nextMincost < minCosts[nextAP]) {
                        minCosts[nextAP] = nextMincost;
                    }
                    pq.offer(new int[]{nextAP, mincost + nextCost, remainStops - 1});
                }

            }
        }
        return -1; 
    }
}

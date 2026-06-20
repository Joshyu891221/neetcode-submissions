class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] time : times){
            adj.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        boolean[] visited = new boolean[n + 1];
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minheap.offer(new int[]{k, 0});

        int countNode = 0;
        int timeSpend = 0;

        while(!minheap.isEmpty()){
            int[] curr = minheap.poll();
            int node = curr[0];
            int time = curr[1];

            if(visited[node]) continue;
            
            visited[node] = true;
            timeSpend = Math.max(timeSpend, time);
            countNode++;

            if(countNode == n) return timeSpend;

            if(adj.containsKey(node)){
                for(int[] neighbor : adj.get(node)){
                    int nextNode = neighbor[0];
                    int nextTimeSpend = neighbor[1];

                    int nextTime = time + nextTimeSpend;

                    if(nextTime < dist[nextNode]){
                        dist[nextNode] = nextTime;
                        minheap.offer(new int[]{nextNode, nextTime});
                    }
                }
            }

        }
        return countNode == n ? timeSpend: -1;

    }
}

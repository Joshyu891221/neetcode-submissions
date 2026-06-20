class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] time : times){
            adj.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{k, 0});

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        boolean[] visited = new boolean[n + 1];
        int count = 0;
        int maxTime = 0;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int node = curr[0];
            int time = curr[1];

            if(visited[node]) continue;

            visited[node] = true;
            count++;
            maxTime = Math.max(maxTime, time);

            if(count == n) return maxTime;

            if(adj.containsKey(node)){
                for(int[] neighbor : adj.get(node)){
                    int nextNode = neighbor[0];
                    int travelTime = neighbor[1];

                    int nextTime = travelTime + time;

                    if(nextTime < dist[nextNode]){
                        dist[nextNode] = nextTime;
                        queue.offer(new int[]{nextNode, nextTime});
                    }
                }
            }
        }

        return count == n ? maxTime : -1;
    }
}

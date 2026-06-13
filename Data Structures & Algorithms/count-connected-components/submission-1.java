class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        // queue.offer(0);
        

        for(int i = 0; i < n; i++){

            if (!visited[i]){
                queue.offer(i);
                visited[i] = true;
                count++;
            }

            while(!queue.isEmpty()){
                int curr = queue.poll();
                for(int neighbor : adj.get(curr)){
                    if(!visited[neighbor]){
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
        return count;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n - 1 != edges.length) return false;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(0);
        visited.add(0);

        while (!queue.isEmpty()){
            int curr = queue.poll();
            for( int node : adj.get(curr)){
                if(!visited.contains(node)){
                    visited.add(node);
                    queue.offer(node);
                }
            }
        }

        return visited.size() == n;
    }
}

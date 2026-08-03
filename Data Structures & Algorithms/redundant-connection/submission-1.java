class Solution {
    private int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        for(int i = 1; i <= n; i ++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int rootu = find(u);
            int rootv = find(v);

            if(rootu == rootv){
                return edge;
            }

            parent[rootv] = rootu;
        }
        return new int[0];
    }

    public int find(int node){
        if(parent[node] == node){
            return node;
        }
        int root = find(parent[node]);
        parent[node] = root;
        return root;
    }
}

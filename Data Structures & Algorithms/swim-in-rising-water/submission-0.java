class Solution {
    private static int[][] dirs;
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        queue.offer(new int[]{0, 0});

        int minTime = 0;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            minTime = Math.max(minTime , grid[r][c]);

            if(r == n - 1 && c == n - 1) return minTime;

            for(int[] dir : dirs){
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || visited[nextR][nextC]) continue;

                queue.offer(new int[]{nextR, nextC});
                visited[nextR][nextC] = true;
            }
        }
        return minTime;
    }
}

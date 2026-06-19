class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 0){
                    q.offerLast(new int[]{r, c});
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[] dir : dirs){
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                if(nextR < 0 || nextR >= m || nextC < 0 || nextC >= n) continue;

                if(grid[nextR][nextC] != Integer.MAX_VALUE) continue;

                grid[nextR][nextC] = grid[r][c] + 1;

                q.offerLast(new int[]{nextR, nextC});
            }

        }
    }
}

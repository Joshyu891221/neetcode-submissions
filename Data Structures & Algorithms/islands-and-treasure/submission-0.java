class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Deque<int[]> q = new ArrayDeque<>();

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 0){
                    q.offerLast(new int[]{r, c});
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1,0}, {-1, 0}};
        while(!q.isEmpty()){
            int[] curr = q.pollFirst();
            int r = curr[0];
            int c = curr[1];

            for(int[] dir : dirs){
                int nextr = r + dir[0];
                int nextc = c + dir[1];

                if(nextr < 0 || nextr >= m || nextc < 0 || nextc >= n) continue;

                if(grid[nextr][nextc] == Integer.MAX_VALUE){
                    grid[nextr][nextc] = grid[r][c] + 1;
                    q.offerLast(new int[]{nextr, nextc});
                }
            }

            
        }
    }
}

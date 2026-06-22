class Solution {
    private int m;
    private int n;
    private int[][] dirs;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int res = 0;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 1){
                    res = Math.max(res, dfs(r, c, grid));
                }
            }
        }
        return res;
    }
    public int dfs(int r, int c, int[][] grid){

        if (r < 0 || c < 0 || r >= m || c >= n  || grid[r][c] == 0){
            return 0;
        }

        int area = 1;
        grid[r][c] = 0;
        for(int[] dir : dirs){
            int nextR = r + dir[0];
            int nextC = c + dir[1];

            area += dfs(nextR, nextC, grid);
        }
        return area;
    }
}

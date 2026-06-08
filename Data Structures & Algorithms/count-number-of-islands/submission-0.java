class Solution {
    private int group = 0;

    public int numIslands(char[][] grid) {

        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    group++;
                    dfs(grid, r, c);
                }
            }
        }
        return group;
    }
    public void dfs(char[][] grid, int r, int c){
        
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
        
    }

}

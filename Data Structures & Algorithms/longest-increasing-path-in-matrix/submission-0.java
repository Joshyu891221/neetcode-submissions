class Solution {
    private int m;
    private int n;
    private int[][] dirs;
    private int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        dp = new int[m][n];
        int res = 0;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                res = Math.max(dfs(matrix, r, c), res);
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int r, int c){
        if(dp[r][c] != 0) return dp[r][c];

        int currLen = 1;

        for(int[] dir : dirs){
            int nextR = r + dir[0];
            int nextC = c + dir[1];

            if(nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || matrix[nextR][nextC] <= matrix[r][c]) continue;

            int neighbor = 1 + dfs(matrix, nextR, nextC);
            currLen = Math.max(neighbor, currLen);
        }

        dp[r][c] = currLen;
        return currLen;
        
    }
}

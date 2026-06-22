class Solution {
    private int[][] dirs;
    private int m;
    private int n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int r = 0; r < m; r++){
            if(board[r][0] == 'O') dfs(board, r, 0);
            if(board[r][n - 1] == 'O') dfs(board, r, n - 1);
        }

        for(int c = 0; c < n; c++){
            if(board[0][c] == 'O') dfs(board, 0, c);
            if(board[m - 1][c] == 'O') dfs(board, m - 1, c);
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(board[r][c] == 'O') board[r][c] = 'X';
                if(board[r][c] == '.') board[r][c] = 'O';
            }
        }
    }
    public void dfs(char[][] board, int r, int c){
        if(r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'O') return;

        board[r][c] = '.';

        for(int[] dir : dirs){
            int nextR = r + dir[0];
            int nextC = c + dir[1];

            dfs(board, nextR, nextC);
        }
    } 
}

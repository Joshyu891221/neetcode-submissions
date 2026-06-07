class Solution {
    private int rows, cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){

                if(backTrack(r, c, word, board, 0)){
                    return true;
                };
            }
        }
        return false;
    }
    public boolean backTrack(int r, int c, String word, char[][] board, int count){
        if (count == word.length()){
            return true;
        }

        if ( r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] == '.' || board[r][c] != word.charAt(count)) {
            return false;
        }
        board[r][c] = '.';
        boolean res = backTrack(r + 1, c, word, board, count + 1) ||
                      backTrack(r - 1, c, word, board, count + 1) ||
                      backTrack(r, c + 1, word, board, count + 1) ||
                      backTrack(r, c - 1, word, board, count + 1);
        board[r][c] = word.charAt(count);

        return res;


    }
}

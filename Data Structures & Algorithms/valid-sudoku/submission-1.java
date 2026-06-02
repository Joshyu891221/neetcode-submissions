class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c != '.'){
                    String r_key = c + "in row" + i;
                    String c_key = c + "in col" + j;
                    String b_key = c + "in box" + ((i / 3) * 3 + (j / 3));
                    if(!set.add(r_key)||!set.add(c_key)||!set.add(b_key)){
                        return false;
                    }
                
                }
            }
        }
        // boolean[][] rows = new boolean[9][9];
        // boolean[][] cols = new boolean[9][9];
        // boolean[][] boxes = new boolean[9][9];

        // for (int i = 0; i < 9; i++){
        //     for (int j = 0; j < 9; j++){
        //         char c = board[i][j];
        //         if (c == '.'){ continue; }
        //         int box = ((i / 3 ) * 3 + (j / 3));
        //         int num_c = c - '1';
        //         if(rows[i][num_c]||cols[j][num_c]||boxes[box][num_c]){
        //             return false;
        //         }
        //         rows[i][num_c] = true;
        //         cols[j][num_c] = true;
        //         boxes[box][num_c] = true;
        //     }
        // }
        return true;
        // Set<String> set = new HashSet<>();

        // for (int i = 0; i < 9; i ++){
        //     for (int j = 0; j < 9; j++){
        //         if (board[i][j] == '.'){ continue; }

        //         String row = board[i][j] + "in row" + i;
        //         String col = board[i][j] + "in col" + j;
        //         String box = board[i][j] + "in box" + ((i/3)*3+(j/3));
        //         if(!set.add(row)||!set.add(col)||!set.add(box)){
        //             return false;
        //         }
        //     }
        // }
        // boolean[][] rows = new boolean[9][9];
        // boolean[][] cols = new boolean[9][9];
        // boolean[][] boxes = new boolean[9][9];

        // for (int i = 0; i < 9; i ++){
        //     for (int j = 0; j < 9; j ++){
                
        //         if (board[i][j] == '.'){ continue;}
        //         int num = board[i][j] - '1';
        //         int box = (i / 3) * 3 + (j / 3);

        //         if (rows[i][num]||cols[j][num]||boxes[box][num]){
        //             return false;
        //         }
        //         rows[i][num] = true;
        //         cols[j][num] = true;
        //         boxes[box][num] = true;
        //     }
        // }
        
    }
}

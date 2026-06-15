class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int lrow = 0, rrow = m - 1;

        while(lrow < rrow){
            int midrow = lrow + (rrow - lrow) / 2;

            if(matrix[midrow][n - 1] < target){
                lrow = midrow + 1;
            }else{
                rrow = midrow;
            }
            // if(rrow - lrow <= 1){
            //     break;
            // } 
        }

        int lcol = 0, rcol = n - 1;
        while(lcol <= rcol){
            int midcol = lcol + (rcol - lcol) / 2;
            
            if(matrix[lrow][midcol] == target){
                return true;
            }

            if(matrix[lrow][midcol] < target){
                lcol = midcol + 1;
            }else{
                rcol = midcol - 1;
            }

        }

        return false;
    }
}

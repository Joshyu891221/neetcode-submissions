class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int top = 0;
        int r = n - 1;
        int bottom = m - 1;
        List<Integer> res = new ArrayList<>();

        while(l <= r && bottom >= top){
            for(int i = l; i <= r; i++){
                res.add(matrix[top][i]);
            }

            top++;
            if(top > bottom) break;

            for(int i = top; i <= bottom; i++){
                res.add(matrix[i][r]);
            }
            r--;
            if(l > r) break;

            for(int i = r; i >= l; i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            
            for(int i = bottom; i >= top; i--){
                res.add(matrix[i][l]);
            }
            l++;
        }
        return res;
    }
}

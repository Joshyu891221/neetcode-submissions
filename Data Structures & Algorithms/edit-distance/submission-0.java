class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int r = 0; r <= m; r++){
            dp[r][0] = r;
        }

        for(int c = 0; c <= n; c++){
            dp[0][c] = c;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    int replace = dp[i - 1][j - 1] + 1;
                    int insert =  dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;

                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }

        }

        return dp[m][n];
    }
}

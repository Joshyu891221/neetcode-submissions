class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for(int r = 1; r <= m; r++){
            dp[r][0] = dp[r - 1][0] && s1.charAt(r - 1) == s3.charAt(r - 1);
        }

        for(int c = 1; c <= n; c++){
            dp[0][c] = dp[0][c - 1] && s2.charAt(c - 1) == s3.charAt(c - 1);
        }

        for(int r = 1; r <= m; r ++){
            for(int c = 1; c <= n; c++){
                char s3Char = s3.charAt(r + c - 1);
                boolean fromS1 = dp[r - 1][c] && s1.charAt(r - 1) == s3Char;
                    
                boolean fromS2 = dp[r][c - 1] && s2.charAt(c - 1) == s3Char;
                        
                dp[r][c] = fromS1 || fromS2;
                
            }
        }
        return dp[m][n];
    }
}

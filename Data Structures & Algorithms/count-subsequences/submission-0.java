class Solution {
    private int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return dfs(s, t, 0, 0);
    }
    public int dfs(String s, String t, int sIndex, int tIndex){
        if(tIndex == t.length()) return 1;
        if(sIndex == s.length()) return 0;


        if(dp[sIndex][tIndex] != -1) return dp[sIndex][tIndex];

        int res = 0;

        if(s.charAt(sIndex) == t.charAt(tIndex)){
            res = dfs(s, t, sIndex + 1, tIndex) + dfs(s, t, sIndex + 1, tIndex + 1);
        }else{
            res = dfs(s, t, sIndex + 1, tIndex);
        }

        dp[sIndex][tIndex] = res;

        return res;
    }
}

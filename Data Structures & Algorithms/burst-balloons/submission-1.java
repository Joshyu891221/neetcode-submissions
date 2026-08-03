class Solution {
    private int[][] memo;
    private int[] vals; 
    public int maxCoins(int[] nums) {
        int n = nums.length;
        vals = new int[n + 2];
        vals[0] = 1;
        vals[n + 1] = 1;

        for(int i = 0; i < n; i++){
            vals[i + 1] = nums[i];
        }

        memo = new int[n + 2][n + 2];

        return dfs(0, n + 1);
    }

    public int dfs(int l, int r){
        if(l + 1 >= r) return 0;

        if(memo[l][r] > 0) return memo[l][r];

        int maxVal = 0;

        for(int k = l + 1; k < r; k++){
            int score = dfs(l, k) 
                      + dfs(k, r)
                      + (vals[l] * vals[k] * vals[r]);
            maxVal = Math.max(maxVal, score);
        }
        memo[l][r] = maxVal;
        
        return memo[l][r];
    }
}

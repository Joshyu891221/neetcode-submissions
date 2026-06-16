class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum < Math.abs(target)) return 0;
        if((sum + target) % 2 == 1) return 0;  
        int goal = (sum + target) / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][goal + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= goal; j++){
                int currnum = nums[i - 1];
                if(currnum > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - currnum];
                }
            }
        } 

        return dp[n][goal];
    }
}

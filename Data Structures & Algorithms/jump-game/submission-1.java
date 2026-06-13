class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];

        dp[n] = true;

        for(int i = n - 1; i > 0; i--){
            for(int j = 1; j <= nums[i - 1]; j++){
                if(i + j <= n && dp[j + i]){
                    dp[i] = true;
                }
            }
        }

        return dp[1];
    }
}

class Solution {
    private int[] dp;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        int res = 1;
        for(int i = 0; i < n; i++){
            res = Math.max(res, dfs(nums, i));
        }
        return res;
    }

    public int dfs(int[] nums, int index){
        if (dp[index] != -1){
            return dp[index];
        }

        int l = 1;
        for(int j = index + 1; j < nums.length; j++){
            if(nums[index] < nums[j]){
                l = Math.max(l, 1 + dfs(nums, j));
            }
        }
        dp[index] = l;
        return l;
        
    }
}
